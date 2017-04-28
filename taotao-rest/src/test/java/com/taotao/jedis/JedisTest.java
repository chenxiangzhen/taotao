package com.taotao.jedis;

import com.taotao.rest.component.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-04-28-19:22
 */
public class JedisTest {

    // 单机版测试
    @Test
    public void testJedisSingle() throws Exception {
        Jedis jedis = new Jedis("192.168.204.131", 6379);
        jedis.set("test", "hello jedis");
        String string = jedis.get("test");
        System.out.println(string);
        jedis.close();
    }

    // 使用连接池
    @Test
    public void testJedisPool() throws Exception {
        // 创建一个连接池对象，单例
        JedisPool jedisPool = new JedisPool("192.168.204.131", 6379);
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get("test");
        System.out.println(result);
        jedis.close();
        // 系统关闭时，关闭连接池
        jedisPool.close();
    }

    // 集群版测试
    @Test
    public void testJedisCluster() throws Exception {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.204.131", 7001));
        nodes.add(new HostAndPort("192.168.204.131", 7002));
        nodes.add(new HostAndPort("192.168.204.131", 7003));
        nodes.add(new HostAndPort("192.168.204.131", 7004));
        nodes.add(new HostAndPort("192.168.204.131", 7005));
        nodes.add(new HostAndPort("192.168.204.131", 7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        jedisCluster.set("name", "zhangsan");
        jedisCluster.set("value", "100");
        String name = jedisCluster.get("name");
        String value = jedisCluster.get("value");
        System.out.println(name);
        System.out.println(value);
        // 系统关闭时，关闭
        jedisCluster.close();
    }

    @Test
    public void testJedisClientSpring() throws Exception {
        // 创建Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        // 从容器中获取JedisClient对象
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
        // 操作redis
        jedisClient.set("client1", "1000");
        String string = jedisClient.get("client1");
        System.out.println(string);
    }
}
