package com.luminahi.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Worker {

    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicQos(1);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(String.format("[.] Received [%s]", message));

                try {
                    doWork(message);
                } finally {
                    System.out.println("[x] done");
                    long deliveryTag = delivery.getEnvelope().getDeliveryTag();
                    channel.basicAck(deliveryTag, false);
                }
            };

            channel.basicConsume(QUEUE_NAME, false, deliverCallback, c -> {});
        } catch( IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void doWork(String task) {
        int seconds = task.length();
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
