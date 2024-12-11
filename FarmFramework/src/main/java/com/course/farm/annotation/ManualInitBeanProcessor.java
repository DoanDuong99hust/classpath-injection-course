package com.course.farm.annotation;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class ManualInitBeanProcessor {
    public static List<Object> createAnnotatedObjects(String packageName) {
        List<Object> objects = new ArrayList<>();

        try {
            // Use a library like Reflections to scan the package (add dependency for Reflections)
            Reflections reflections = new Reflections(packageName);

            // Get all classes annotated with @AutoCreate
            for (Class<?> clazz : reflections.getTypesAnnotatedWith(ManualInitBean.class)) {
                // Create an instance of the annotated class
                Object instance = clazz.getDeclaredConstructor().newInstance();
                objects.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objects;
    }
}
