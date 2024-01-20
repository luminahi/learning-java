package com.luminahi.vectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class App {
    public static void main(String[] args) throws InterruptedException {
        getTimeFromArrayList();
        getTimeFromVectorList();
        getTimeFromArrayListWithThreads();
        getTimeFromVectorListWithThreads();
    }

    private static void getTimeFromArrayList() {
        int size = 1_000_000;
        long startTime = System.currentTimeMillis();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            intList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList " + (endTime - startTime) + "ms");
    }

    private static void getTimeFromVectorList() {
        int size = 1_000_000;
        long startTime = System.currentTimeMillis();
        List<Integer> intVector = new Vector<>();
        for (int i = 0; i < size; i++) {
            intVector.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("VectorList " + (endTime - startTime) + "ms");
    }

    private static void getTimeFromVectorListWithThreads() throws InterruptedException {
        int size = 1_000_000;
        long startTime = System.currentTimeMillis();
        List<Integer> intVector = new Vector<>();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                intVector.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                intVector.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long endTime = System.currentTimeMillis();
        System.out.println("VectorList with threads: " + (endTime - startTime) + "ms");
    }

    private static void getTimeFromArrayListWithThreads() throws InterruptedException {
        int size = 1_000_000;
        long startTime = System.currentTimeMillis();

        // List<Integer> intList = new ArrayList<>();
        List<Integer> intList = Collections.synchronizedList(new ArrayList<>());
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                intList.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                intList.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList With threads: " + (endTime - startTime) + "ms");
    }
}
