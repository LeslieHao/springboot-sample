package com.hh.springbootredis.redis;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ZParams;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * @author HaoHao
 * @date 2018/7/17下午9:14
 */
public class RedisUtil {

    private static JedisPool jedisPool;

    private static Jedis jedis;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1024);
        jedisPool = new JedisPool("127.0.0.1", 6379);
        jedis = jedisPool.getResource();
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void set(String key, String value) {
        jedis.set(key, value);
    }

    public static String get(String key) {
        return jedis.get(key);
    }

    public static void setList(String key, List<String> list) {
        jedis.lpush(key, list.get(0), list.get(1));
    }

    public static void remove(String key) {
        jedis.del(key);
    }

    /**
     * String 自增1
     *
     * @param key
     */
    public static void incr(String key) {
        try {
            jedis.incr(key);
        } catch (JedisDataException e) {
            System.out.println("非数值类型");
            e.printStackTrace();
        }
    }

    public static void incrBy(String key, int i) {
        try {
            jedis.incrBy(key, i);
        } catch (JedisDataException e) {
            System.out.println("非数值类型");
            e.printStackTrace();
        }
    }

    public static void decr(String key) {
        try {
            jedis.decr(key);
        } catch (JedisDataException e) {
            System.out.println("非数值类型");
            e.printStackTrace();
        }
    }

    public static void decr(String key, int i) {
        try {
            jedis.decrBy(key, i);
        } catch (JedisDataException e) {
            System.out.println("非数值类型");
            e.printStackTrace();
        }
    }

    public static void watch() {
//        jedis.watch()
    }

    @Test
    public void zInterStore() {
//        jedis.zadd("key1", 1, "a");
//        jedis.zadd("key1", 2, "b");
//        jedis.zadd("key2", 3, "a");
//        jedis.zadd("key2", 4, "b");

        // key1 key2 取交集 score 相加
//        jedis.zinterstore("key2", "key1", "key2");

        ZParams zParams = new ZParams();
        // 取最大的score
//        zParams.aggregate(ZParams.Aggregate.MAX);
        // 取最小的score
//        zParams.aggregate(ZParams.Aggregate.MIN);
        // 取和(默认)
        zParams.aggregate(ZParams.Aggregate.SUM);
        // 设置key1 key2 的权重  计算分数时乘以权重
        zParams.weightsByDouble(1, 2);
        jedis.zinterstore("key2", zParams, "key1", "key2");

    }

    public static void main(String[] args) {
//        jedis.set("count", "0");
        incr("test");
        System.out.println(jedis.get("count"));
        System.out.println();
    }
}
