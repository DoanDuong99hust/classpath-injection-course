package com.course.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JarServlet extends HttpServlet {
    private final String jarPath;

    public JarServlet(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    protected void doGet(InputStream input, OutputStream output) throws IOException {
        try {
            // Run the JAR dynamically
            JarRunner.run(jarPath);
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "Content-Length: 19\r\n" +
                    "\r\n" +
                    "JAR executed successfully!";
            output.write(response.getBytes());
        } catch (Exception e) {
            String response = "HTTP/1.1 500 Internal Server Error\r\n\r\n" + e.getMessage();
            output.write(response.getBytes());
        }
    }
}

