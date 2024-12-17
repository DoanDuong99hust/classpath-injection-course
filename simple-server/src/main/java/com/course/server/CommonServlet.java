package com.course.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class CommonServlet extends HttpServlet {
    private final Object controllerClass;
    private final Method method;

    public CommonServlet(Object controllerClass, Method method) {
        this.controllerClass = controllerClass;
        this.method = method;
    }

    @Override
    protected void doGet(InputStream input, OutputStream output) throws Exception {
        try {
            // Run the JAR dynamically
            super.doGet(input, output);
            Object rs = method.invoke(controllerClass);
            output.write(rs.toString().getBytes());
        } catch (Exception e) {
            String response = "HTTP/1.1 500 Internal Server Error\r\n\r\n" + e.getMessage();
            output.write(response.getBytes());
        }
    }
}
