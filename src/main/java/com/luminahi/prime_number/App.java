package com.luminahi.prime_number;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class App {

    public static void main(String[] args) {
        long size = 500;
        
        long start = System.currentTimeMillis();
        long result = multiThreadPrimeSum(size);
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(String.format("%s ms", end - start));

        start = System.currentTimeMillis();
        result = calcSumOfPrimeNumbers(0, size);
        System.out.println(result);
        end = System.currentTimeMillis();
        System.out.println(String.format("%s ms", end - start));
    }

    static private long multiThreadPrimeSum(long size) {
        AtomicLong accumulator = new AtomicLong(0);
        List<Thread> threads = new ArrayList<>();
        
        final long processors = Runtime.getRuntime().availableProcessors();
        final long part = (size / processors);
        final long remaining = size % processors;

        for (int i = 0; i < processors; i++) {
            final int step = i;
            long start = step * part;
            long end = (step + 1) * part;
            Thread thread = null;

            // verify if the remaining value of (size / processors) is 
            // properly added to the calculation  
            if (step == processors - 1)
                thread = startTask(start, end + remaining, accumulator);
            else
                thread = startTask(start, end, accumulator);
            
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("All threads have finished");
        return accumulator.get();
    }

    static private Thread startTask(long start, long end, AtomicLong accumulator) {
        return new Thread(() -> {
            long partialSum = calcSumOfPrimeNumbers(start, end);
            accumulator.addAndGet(partialSum);
        });
    }

    static private boolean isPrimeNumber(Long number) {
        if (number < 2) return false;
        for (long i = 2L; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    static private long calcSumOfPrimeNumbers(long start, long end) {        
        return LongStream.range(start, end)
            .filter(number -> isPrimeNumber(number))
            .reduce((previous, current) -> previous + current)
            .getAsLong();
    }
}
