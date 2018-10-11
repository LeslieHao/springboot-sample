package com.hh.springbootredis.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * @author HaoHao
 * @Description:
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

    public static  void setList(String key, List<String > list) {
        jedis.lpush(key, list.get(0), list.get(1));
    }

    public static void remove(String key) {
        jedis.del(key);
    }

    /**
     * String 自增1
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
    public static void incrBy(String key,int i) {
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
    public static void decr(String key,int i) {
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


    public static void main(String[] args) {
//        jedis.set("count", "0");
        incr("test");
        System.out.println(jedis.get("count"));
    }
}
