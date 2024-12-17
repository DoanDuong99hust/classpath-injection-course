package com.course.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class HttpServlet {
    public void service(String method, InputStream input, OutputStream output) throws Exception {
        if ("GET".equalsIgnoreCase(method)) {
            doGet(input, output);
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost(input, output);
        }
        // Add support for other methods if needed
    }

    protected void doGet(InputStream input, OutputStream output) throws Exception {}
    protected void doPost(InputStream input, OutputStream output) throws IOException {}
}

