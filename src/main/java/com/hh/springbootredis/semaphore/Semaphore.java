package com.hh.springbootredis.semaphore;

import java.io.IOException;
import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

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
            System.out.println("uuid:"+uuid+",未获取到信号量");
            // 释放刚插入的数据
            pipeline.zrem(key, uuid);
            pipeline.sync();
            return false;
        }
        pipeline.syncAndReturnAll();
        System.out.println("uuid:"+uuid+",获取到信号量");
        pipeline.close();
        return true;
    }

    /**
     * 公平信号量
     * @param jedis
     * @param key
     * @return
     */
    static boolean fairSemaphore(Jedis jedis, String key) {
        String uuid = UUID.randomUUID().toString();
        long now = System.currentTimeMillis();
        Pipeline pipelined = jedis.pipelined();

        // 移除超时序列的过期数据
        pipelined.zremrangeByScore(key, 0, now - TIME_OUT);

        // 超时序列和自增序列取交集

        // todo
//        pipelined.zinterstore(key, );

        return false;
    }

}
