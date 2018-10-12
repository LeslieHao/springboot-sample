package com.hh.springbootredis.semaphore;

import java.io.IOException;
import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.ZParams;

/**
 * @author HaoHao
 * @date 2018/10/9下午2:28
 */
public class Semaphore {


    // 频次限制
    private static final int LIMIT = 5;

    private static final int TIME_OUT = 500;

    /**
     * 计数信号量
     *
     * @param key 超时序列的key
     * @return 返回值
     */
    static boolean acquireSemaphore(Jedis jedis, String key) throws IOException {
        String uuid = UUID.randomUUID().toString();
        long now = System.currentTimeMillis();
        // 管道
        Pipeline pipeline = jedis.pipelined();

        // 移除超时信号量
        pipeline.zremrangeByScore(key, 0, now - TIME_OUT);

        pipeline.zadd(key, now, uuid);

        // 获取排名
        Response<Long> response = pipeline.zrank(key, uuid);
        pipeline.syncAndReturnAll();
        Long rank = response.get();
        if (rank >= LIMIT) {
            System.out.println("uuid:" + uuid + ",未获取到信号量");
            // 释放刚插入的数据
            pipeline.zrem(key, uuid);
            pipeline.sync();
            return false;
        }
        pipeline.syncAndReturnAll();
        System.out.println("uuid:" + uuid + ",获取到信号量");
        pipeline.close();
        return true;
    }

    /**
     * 公平信号量
     *
     * @param jedis
     * @return
     */
    static boolean fairSemaphore(Jedis jedis, String key_timeout, String key_count, String key_string) {
        String uuid = UUID.randomUUID().toString();
        long now = System.currentTimeMillis();

        // 移除超时序列的过期数据
        jedis.zremrangeByScore(key_timeout, 0, now - TIME_OUT);

        // 超时序列和自增序列取交集

        ZParams zParams = new ZParams();
        zParams.weightsByDouble(1, 0);
        jedis.zinterstore(key_count, zParams,key_count, key_timeout);

        // 自增
        Long incr = jedis.incr(key_string);

        // 插入超时序列和自增序列
        jedis.zadd(key_timeout, now, uuid);
        jedis.zadd(key_count, incr, uuid);
        Long rank = jedis.zrank(key_count, uuid);
        // 判断rank 位置
        if (rank >= LIMIT) {
            System.out.println("uuid:" + uuid + ",未获取到信号量");
            // 释放
            jedis.zrem(key_timeout, uuid);
            jedis.zrem(key_count, uuid);
            return false;
        }
        System.out.println("uuid:" + uuid + ",获取到信号量");
        return true;
    }


}
