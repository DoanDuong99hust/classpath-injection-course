package com.course.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HelloWorldServlet  extends HttpServlet {
    @Override
    protected void doGet(InputStream input, OutputStream output) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/plain\r\n" +
                "Content-Length: 13\r\n" +
                "\r\n" +
                "Hello, World!";
        output.write(response.getBytes());
    }
}

