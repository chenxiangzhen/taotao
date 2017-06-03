package com.taotao.order.component;

/**
 * Description：Jedis接口
 *
 * @author: ChenXiangzhen
 * create 2017-04-28-19:39
 */
public interface JedisClient {

    public String set(String key, String value);

    public String get(String key);

    public Long hset(String key, String item, String value);

    public String hget(String key, String item);

    public Long incr(String key);

    public Long decr(String key);

    public Long expire(String key, int second);

    public Long ttl(String key);

    public Long hdel(String key, String item);

}
