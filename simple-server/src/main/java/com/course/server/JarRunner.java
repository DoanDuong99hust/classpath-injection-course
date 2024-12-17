package com.course.server;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarRunner {
    public static Class<?> run(String jarPath) {
        try {
            // Load the JAR file dynamically
            File file = new File(jarPath);
            URL jarUrl = file.toURI().toURL();
            URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl});

            // Read the manifest to find the main class
            try (JarFile jarFile = new JarFile(file)) {
                Manifest manifest = jarFile.getManifest();
                String mainClassName = manifest.getMainAttributes().getValue("Main-Class");
                if (mainClassName == null) {
                    throw new IllegalArgumentException("No Main-Class found in JAR manifest.");
                }

                // Load the main class
                Class<?> mainClass = loader.loadClass(mainClassName);

                // Call the main method
                Method mainMethod = mainClass.getMethod("main", String[].class);
                String[] jarArgs = new String[]{}; // Pass arguments to the JAR here
                mainMethod.invoke(null, (Object) jarArgs); // Cast to Object for varargs
                return mainClass;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

