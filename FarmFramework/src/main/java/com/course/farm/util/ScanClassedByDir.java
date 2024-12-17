package com.course.farm.util;


import com.course.farm.annotation.FarmComponent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@FarmComponent()
public class ScanClassedByDir {

    // Method to recursively find classes in a directory
    public static List<Class<?>> findClassFilesInDirectory(String directoryPath, String packageName) throws ClassNotFoundException {

        List<Class<?>> classes = new ArrayList<>();
        File dir = new File(directoryPath);

        // Check if the directory exists
        if (dir.exists() && dir.isDirectory()) {
            getClasses(classes, dir, packageName);
        } else {
            System.err.println("The provided path is not a valid directory.");
        }

        return classes;
    }


    public static List<Class<?>> findClassFilesInRoot(String classPath) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        ClassLoader classLoader = new ClassLoader() {};
        Enumeration<URL> roots = classLoader.getResources(classPath);
        if (roots.hasMoreElements()) {
            URL url = roots.nextElement();
            File root = new File(url.getPath());
            if (root.exists() && root.isDirectory()) {
//                getClasses(classes, root);
            }
        }
        return classes;
    }

    private static void getClasses(List<Class<?>> classes, File root, String packageName) throws ClassNotFoundException {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    classes.addAll(findClassFilesInDirectory(file.getAbsolutePath(), packageName));
                } else if (file.getName().endsWith(".class")) {
                    String fileAbsolutePath = file.getAbsolutePath();
                    String className = fileAbsolutePath.substring(fileAbsolutePath.indexOf("classes"))
                            .substring(fileAbsolutePath.substring(fileAbsolutePath.indexOf("classes"))
                                    .indexOf("/")+1).replace("/",".");
                    className = className.substring(0, className.length()-6);
                    classes.add(Class.forName(className));
                }
            }
        }
    }
}
