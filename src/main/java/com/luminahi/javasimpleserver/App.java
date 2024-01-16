package com.luminahi.javasimpleserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

    public static void listen(final int port) {

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server running at port " + port);
            
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
        listen(8080);
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
            String response = "Hello Client";
            outputStream.write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
