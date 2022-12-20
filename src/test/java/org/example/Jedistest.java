package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class Jedistest {
    private Jedis jedis;
    @BeforeEach
    void setUp(){
        jedis= JedisConnectionFactory.getJedis();
        //jedis.auth("123456");
        jedis.select(0);
    }
    @Test
    void testString(){
        String name = jedis.set("name", "zhangsan");
        System.out.println("name is "+name);
        System.out.println(jedis.get("name"));
    }
    @Test
    void testHash(){
        jedis.hset("user:1","name","lisi");
        jedis.hset("user:1","age","12");
        jedis.hset("user:1","land","china");
    }
    @AfterEach
    void teardown(){
        if(jedis!= null){
            jedis.close();
        }

    }
}
