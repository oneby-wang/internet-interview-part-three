package com.oneby.util;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName RedisUtils
 * @Description TODO
 * @Author Oneby
 * @Date 2021/2/4 17:41
 * @Version 1.0
 */
public class RedisUtils {

    private static JedisPool jedisPool;
    
    private static String hostAddr = "192.168.152.233";

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolConfig, hostAddr, 6379, 100000);
    }

    public static Jedis getJedis() throws Exception {
        if (null != jedisPool) {
            return jedisPool.getResource();
        }
        throw new Exception("Jedispool is not ok");
    }

}
