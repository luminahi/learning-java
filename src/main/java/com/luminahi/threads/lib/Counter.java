package com.luminahi.threads.lib;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}