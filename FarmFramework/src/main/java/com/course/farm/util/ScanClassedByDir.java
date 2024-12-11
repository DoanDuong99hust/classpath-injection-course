package com.course.farm.util;


import com.course.farm.annotation.ManualInitBean;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

@ManualInitBean()
public class ScanClassedByDir {

    // Method to recursively find classes in a directory
    public List<String> findClassFilesInDirectory(String directoryPath) {

        List<String> classes = new ArrayList<>();
        File dir = new File(directoryPath);

        // Check if the directory exists
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            // Iterate through all files and directories
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Recursively go through subdirectories
                        classes.addAll(findClassFilesInDirectory(file.getAbsolutePath()));
                    } else if (file.getName().endsWith(".class")) {
                        // If it's a .java file, check for classes
                        classes.add(file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.err.println("The provided path is not a valid directory.");
        }

        return classes;
    }


    public List<String> findClassFilesInRoot(String classPath) throws IOException {
        List<String> classes = new ArrayList<>();

        ClassLoader classLoader = new ClassLoader() {};
        Enumeration<URL> roots = classLoader.getResources(classPath);
        if (roots.hasMoreElements()) {
            URL url = roots.nextElement();
            File root = new File(url.getPath());
            if (root.exists() && root.isDirectory()) {
                File[] files = root.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            classes.addAll(findClassFilesInDirectory(file.getAbsolutePath()));
                        } else if (file.getName().endsWith(".class")) {
                            classes.add(file.getAbsolutePath());
                        }
                    }
                }
            }
        }
        return classes;
    }
}
