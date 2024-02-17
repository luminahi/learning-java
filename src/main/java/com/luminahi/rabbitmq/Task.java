package com.luminahi.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;

public class Task {

    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
        ) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = String.join(" ", args);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(String.format("[x] Sent %s", message));
        } catch( IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
