package com.course.server;

import java.util.HashMap;
import java.util.Map;

public class ServletRegistry {
    private static final Map<String, HttpServlet> servletMapping = new HashMap<>();

    public static void registerServlet(String path, HttpServlet servlet) {
        servletMapping.put(path, servlet);
    }

    public static HttpServlet getServlet(String path) {
        return servletMapping.get(path);
    }
}

