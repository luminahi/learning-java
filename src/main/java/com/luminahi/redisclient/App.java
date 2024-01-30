package com.luminahi.redisclient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class App {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool("localhost", 6379);
        
        try (Jedis jedis = pool.getResource()) {
            jedis.publish("application", "start!");

            jedis.set("programming language", "java");
            
            jedis.rpush("games", "zelda");
            jedis.rpush("games", "mario");
            jedis.rpush("games", "tes oblivion");
            jedis.rpush("games", "pokemon");
            jedis.rpush("games", "dmc");

            while (jedis.llen("games") > 0) {
                String game = jedis.rpop("games");
                System.out.println("popped: " + game);
                Thread.sleep(1000);
            }

            String p = jedis.get("programming language");

            System.out.println(p);

            jedis.publish("application", "ending");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.close();
        }
    }
}
