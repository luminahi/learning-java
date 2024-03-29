package com.luminahi.javasimpleserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.lang.Runnable;
import java.net.Socket;

public class App {

    public static void listen(final int port, String hostname, Runnable fn) {

        try (ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName(hostname))) {
            fn.run();
            
            while (true) {
                try(Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        listen(8080, "0.0.0.0", () -> { 
            System.out.println("server running at port " + 8080);    
        });
    
    }

    private static void handleClient(Socket clientSocket) {
        System.out.println(
            "accepted connection from " + clientSocket.getInetAddress()
        );

        try (
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()
        ) {
            // read request data from client
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String clientData = new String(buffer, 0, bytesRead);
            System.out.println(clientData);

            // send response to client
            String response = "HTTP/1.1 200 OK\nContent-Type: text/html\nConnection: keep-alive\n\n<h1>Hello, Client!</h1>";
            // String response = "Hello Client";
            outputStream.write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
