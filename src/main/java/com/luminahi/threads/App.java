package com.luminahi.threads;

import com.luminahi.threads.lib.Counter;
import com.luminahi.threads.lib.RunningOperation;

public class App {

    public static void await(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void counter() {
        Counter counter = new Counter();

        Thread counterThread0 = new Thread(() -> {
            for (int i = 0; i < 5;i++) {
                counter.increment();
                System.out.println("T0: " + counter.getCount());
            }
        });

        Thread counterThread1 = new Thread(() -> {
            for (int i = 0; i < 5;i++) {
                counter.increment();
                System.out.println("T1: " + counter.getCount());
            }
        });

        counterThread0.start();
        counterThread1.start();

        try {
            counterThread0.join();
            counterThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("final " + counter.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        counter();

        RunningOperation operation0 = new RunningOperation("x", 5, 1000);
        RunningOperation operation1 = new RunningOperation("y", 5, 1000);

        Thread thread0 = new Thread(operation0);
        Thread thread1 = new Thread(operation1);

        thread0.start();
        thread1.start();
    }
}
