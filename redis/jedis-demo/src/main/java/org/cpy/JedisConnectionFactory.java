package org.cpy;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis 连接池
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;
    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMaxIdle(0);
        jedisPoolConfig.setMaxWaitMillis(1000);
         jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379, 1000, "123456");
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
