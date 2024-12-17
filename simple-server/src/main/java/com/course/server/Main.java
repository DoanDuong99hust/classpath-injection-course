package com.course.server;

import com.course.farm.FarmApplication;
import com.course.farm.annotation.FarmController;
import com.course.farm.annotation.FarmCoreApplication;
import com.course.farm.annotation.FarmGetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * Tomcat
 * Read jar file, scan all class with annotation controller, load all dependencies of this controller
 *
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        int port = 8080; // Server will listen on port 8080
        logger.info("Server started on port {}", port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // Register the servlet
            ServletRegistry.registerServlet("/hello", new HelloWorldServlet());
            Class<?> mainClass = JarRunner.run("/Users/shisui/Documents/LearningProject/classpath-injection-course/customer/target/customer-1.0-SNAPSHOT.jar");

            for (Map.Entry<String, Object> controller : FarmApplication.getFarmControllerMap().entrySet()) {
                Class<?> clazz = controller.getValue().getClass();
                FarmController farmController = clazz.getAnnotation(FarmController.class);
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    ServletRegistry.registerServlet(farmController.path() + method.getAnnotation(FarmGetMapping.class).value(),
                            new CommonServlet(controller.getValue(), method));
                }
            }
            ServletRegistry.registerServlet("/hello-2", new HelloWorldServlet());
            assert mainClass != null;
            if (mainClass.isAnnotationPresent(FarmCoreApplication.class) && mainClass.getAnnotation(FarmCoreApplication.class).enableHttp()) {
                while (true) {
                    Socket clientSocket = serverSocket.accept(); // Accept client connections
                    new Thread(() -> handleClient(clientSocket)).start(); // Handle in a new thread
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (InputStream input = clientSocket.getInputStream();
             OutputStream output = clientSocket.getOutputStream()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String requestLine = reader.readLine(); // Read the request line

            // Parse the HTTP method and path
            if (requestLine == null) {
                return;
            }
            String[] parts = requestLine.split(" ");
            String method = parts[0];
            String path = parts[1];

            // Route to the appropriate servlet
            HttpServlet servlet = ServletRegistry.getServlet(path);
            if (servlet != null) {
                servlet.service(method, input, output);
            } else {
                // Send a 404 Not Found response
                String response = "HTTP/1.1 404 Not Found\r\n\r\n";
                output.write(response.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}