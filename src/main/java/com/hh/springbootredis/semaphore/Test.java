package com.hh.springbootredis.semaphore;

import com.hh.springbootredis.redis.RedisUtil;

import redis.clients.jedis.Jedis;

/**
 * @author HaoHao
 * @date 2018/10/11下午3:55
 */
public class Test {

    private static final String KEY = "timeout_semaphore";

    private static void testSemaphore() throws Exception {
        for (int i = 0; i < 10; i++) {
            Jedis jedis = RedisUtil.getJedis();
            Semaphore.acquireSemaphore(jedis, KEY);
            Thread.sleep(5);
            jedis.close();
        }
    }

    public static void main(String[] args) throws Exception {
        testSemaphore();
    }
}
