package org.cpy;

import com.alibaba.fastjson.JSON;
import org.cpy.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
public class RedisDemoApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 测试字符串
     */
    @Test
    void testString() {
        redisTemplate.opsForValue().set("name", "刀哥");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    /**
     * 测试序列化
     */
    @Test
    void testObject(){
        //手动序列化
        User user = new User((long) 2, "李四");
        String string = JSON.toJSONString(user);
        redisTemplate.opsForValue().set("user:002",string);
        String s =(String) redisTemplate.opsForValue().get("user:002");
        System.out.println(JSON.parseObject(s,User.class).getName());
        //自动序列化
//        redisTemplate.opsForValue().set("user:001",new User((long)1,"虎哥"));
//        User user = (User) redisTemplate.opsForValue().get("user:001");
        System.out.println(user);
    }
    @Test
    void testHash(){
        Map entries = redisTemplate.opsForHash().entries("user:003");
        entries.put("id","003");
        Object id = redisTemplate.opsForHash().get("user:003","id");
        System.out.println( id);
    }
}
