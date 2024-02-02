package com.luminahi.redisworker;

import redis.clients.jedis.Jedis;
import com.luminahi.redisworker.lib.RedisWorker;

public class App {

    static Jedis jedis = new Jedis("localhost", 6379);

    public static void main(String args[]) {
        Jedis jedis = new Jedis("localhost", 6379);
        RedisWorker worker = new RedisWorker(jedis, "games");
        worker.startProcessing();
    }
}
