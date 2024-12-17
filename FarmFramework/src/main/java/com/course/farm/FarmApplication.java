package com.course.farm;

import com.course.farm.annotation.*;
import com.course.farm.util.ScanClassedByDir;
import com.course.farm.util.ScanClassesByJar;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FarmApplication {
    private static final Map<String, List<Object>> farmAnnotatedProducts = new HashMap<>();
    private static final Map<String, List<Object>> farmAllProducts = new HashMap<>();
    private static final Map<String, Object> farmControllerMap = new HashMap<>();

    public static void run(Class<?> mainClazz, String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
        Path path = Paths.get(mainClazz.getProtectionDomain().getCodeSource().getLocation().getPath());
        List<Class<?>> instances;
        if (path.toFile().isDirectory()) {
            instances = ScanClassedByDir.findClassFilesInDirectory(path.toFile().getAbsolutePath(), mainClazz.getPackageName());
        } else {
            instances = ScanClassesByJar.getClassesFromJarFile(path.toFile());
        }

        for (Class<?> clazz : instances) {
            if (!clazz.isInterface()) {
                farmAllProducts.put(clazz.getName(), List.of(clazz.getDeclaredConstructor().newInstance()));
                if (!clazz.isAnnotationPresent(FarmController.class)) {
                    Object obj = clazz.getDeclaredConstructor().newInstance();

                    if (clazz.getInterfaces().length > 0) {
                        for (Class<?> i : clazz.getInterfaces()) {
                            farmAnnotatedProducts.put(i.getName(), List.of(obj));
                        }
                    } else {
                        farmAnnotatedProducts.put(clazz.getName(), List.of(clazz.getDeclaredConstructor().newInstance()));
                    }
                }
            }
        }

        for (Class<?> clazz : instances) {
            if (clazz.isAnnotationPresent(FarmController.class)) {
                Field[] fields = clazz.getDeclaredFields();
                Object controllerObject = clazz.getDeclaredConstructor().newInstance();
                for (Field field : fields) {
                    Class<?> fieldClass = field.getType();
                    if (field.isAnnotationPresent(FarmAutowire.class) && farmAnnotatedProducts.get(fieldClass.getName()) == null) {
                        farmAnnotatedProducts.put(fieldClass.getName(), List.of(fieldClass.getDeclaredConstructor().newInstance()));
                    }
                    if (field.isAnnotationPresent(FarmAutowire.class)) {
                        field.setAccessible(true);
                        field.set(controllerObject, farmAnnotatedProducts.get(fieldClass.getName()).get(0));
                    }
                }
                FarmController farmController = clazz.getAnnotation(FarmController.class);
                farmAnnotatedProducts.put(clazz.getName(), List.of(controllerObject, farmController.path()));
                farmControllerMap.put(clazz.getName(), controllerObject);
            }
        }
    }

    public static Map<String, List<Object>> getFarmAnnotatedProducts() {
        return farmAnnotatedProducts;
    }

    public static Map<String, List<Object>> getFarmAllProducts() {
        return farmAllProducts;
    }

    public static Map<String, Object> getFarmControllerMap() {
        return farmControllerMap;
    }
}
