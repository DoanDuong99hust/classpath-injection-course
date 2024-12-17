package com.course.farm.util;

import com.course.farm.annotation.FarmComponent;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@FarmComponent
public class ScanClassesByJar {

    public List<String> findClassNames(String jarFilePath) throws IOException {
        return new ArrayList<>(getClassNamesFromJarFile(new File(jarFilePath)));
    }

    public Set<Class> findClasses(String jarFilePath) throws ClassNotFoundException, IOException {
        return new HashSet<>(getClassesFromJarFile(new File(jarFilePath)));
    }

    public static Set<String> getClassNamesFromJarFile(File givenFile) throws IOException {
        Set<String> classNames = new HashSet<>();
        try (JarFile jarFile = new JarFile(givenFile)) {
            Enumeration<JarEntry> e = jarFile.entries();
            while (e.hasMoreElements()) {
                JarEntry jarEntry = e.nextElement();
                if (jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName()
                            .replace("/", ".")
                            .replace(".class", "");
                    classNames.add(className);
                }
            }
            return classNames;
        }
    }

    public static List<Class<?>> getClassesFromJarFile(File jarFile) throws IOException, ClassNotFoundException {
        Set<String> classNames = getClassNamesFromJarFile(jarFile);
        List<Class<?>> classes = new ArrayList<>(classNames.size());
        try (URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()})) {
            for (String name : classNames) {
                classes.add(classLoader.loadClass(name));
            }
        }
        return classes;
    }
}
