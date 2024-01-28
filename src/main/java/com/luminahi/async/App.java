package com.luminahi.async;

import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("application start");

        await(5000, 1).thenAcceptAsync(System.out::println);

        System.out.println("application midway");

        var timeout = setTimeOut(15000);
        await(3000, 4).thenAcceptAsync(System.out::println);


        System.out.println(await(5000, 3).get());

        // wait for timeout to end
        timeout.get();
        System.out.println("application end");
    }

    static CompletableFuture<String> await(long ms, int taskId) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task end " + taskId;
        });

        return future;
    }

    static CompletableFuture<Void> setTimeOut(long ms) {
        return CompletableFuture.runAsync(() -> {
            for (int i = 0; i < ms / 1000.0; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("seconds: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
