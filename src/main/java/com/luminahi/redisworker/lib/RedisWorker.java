package com.luminahi.redisworker.lib;

import java.util.List;
import redis.clients.jedis.Jedis;

public class RedisWorker {

    private final Jedis jedis;
    private final String taskName;

    public RedisWorker(Jedis jedis, String taskName) {
        this.jedis = jedis;
        this.taskName = taskName;
    }

    private void processTask() {
        List<String> task = jedis.blpop(5, taskName);
        if (task != null)
            System.out.println(task.get(0) + " " +  task.get(1));
        else
            System.out.println("No items in the queue! Waiting...");
    }

    public void startProcessing() {
        System.out.println("processing the queue");
        while (true) {
            processTask();
        }
    }
}
