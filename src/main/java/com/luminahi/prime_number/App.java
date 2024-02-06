package com.luminahi.prime_number;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class App {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        long result = multiThreadPrimeSum(5_000_000);
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(String.format("%s ms", end - start));

        start = System.currentTimeMillis();
        result = calcSumOfPrimeNumbers(0, 5_000_000);
        System.out.println(result);
        end = System.currentTimeMillis();
        System.out.println(String.format("%s ms", end - start));
    }

    static private long multiThreadPrimeSum(long size) throws InterruptedException {
        AtomicLong accumulator = new AtomicLong(0);
        List<Thread> threads = new ArrayList<>();
        
        int processors = Runtime.getRuntime().availableProcessors();
        long partial = size / processors;

        for (int i = 0; i < processors; i++) {
            final int step = i;
            Thread thread = new Thread(() -> {
                long temp = calcSumOfPrimeNumbers(step * partial, (step + 1) * partial);
                accumulator.addAndGet(temp);
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("All threads have finished");
        return accumulator.get();
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
