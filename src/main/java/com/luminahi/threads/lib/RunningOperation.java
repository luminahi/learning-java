package com.luminahi.threads.lib;

public class RunningOperation implements Runnable {

    private final String name;
    private final int count;
    private final int interval;

    public RunningOperation(String name, int count, int interval) {
        this.name = name;
        this.count = count;
        this.interval = interval;
    }

    public void setTimeout() {
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("%s - %s", name, i));
        }
    }

    @Override
    public void run() {
        setTimeout();
    }
}