package com.luminahi.publisher_confirms;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;
import java.util.stream.LongStream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class App {

    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] args) {
        
        
        Queue<String> messageQueue = new LinkedList<>();

        LongStream.range(0, 50_000).forEach(element -> messageQueue.add("message: " + element));
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
        ) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.confirmSelect();

            ConcurrentNavigableMap<Long, String> confirmMap = 
                new ConcurrentSkipListMap<>();
            
            // callback for success in confirm listener
            ConfirmCallback cleanConfirms = (sequenceNumber, multiple) -> {
                if (multiple) {
                    ConcurrentNavigableMap<Long, String> confirmed =
                        confirmMap.headMap(sequenceNumber, true);
                    confirmed.clear();
                } else {
                    confirmMap.remove(sequenceNumber);
                }
            };

            channel.addConfirmListener(
                cleanConfirms, 
                (sequenceNumber, multiple) -> {
                    String body = confirmMap.get(sequenceNumber);
                    System.err.format(
                        "Message with body %s has been nack-ed. Sequence number: %d, multiple: %b%n", 
                        body, sequenceNumber, multiple
                    );
                    cleanConfirms.handle(sequenceNumber, multiple);
                }
            );
            
            // sending messages from local queue
            while (messageQueue.size() > 0) {
                long sequenceNumber = channel.getNextPublishSeqNo();
                String message = messageQueue.poll();
                confirmMap.put(sequenceNumber, message);
                
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(String.format("[x] Sent %s", message));
            }

        } catch(IOException | TimeoutException e) {
            e.printStackTrace();
        }
        
    }
}
