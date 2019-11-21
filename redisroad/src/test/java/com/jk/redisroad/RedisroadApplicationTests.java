package com.jk.redisroad;

import com.jk.redisroad.client.RedisClient;
import com.jk.redisroad.client.RedisUtil;
import com.jk.redisroad.client.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@EnableConfigurationProperties
class RedisroadApplicationTests {

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
    }


    @Test
    public void test_String() {
//        String result = redisClient.getKeyStringValue("jk"); System.out.println(result);
//        System.out.println(redisTemplate.delete(redisTemplate.keys("*")));
//        String result = redisClient.getKeyStringValue("name"); System.out.println(result);
        redisTemplate.delete("name");
//        redisClient.setKeyStringValue("jk" , "map");
        redisClient.setKeyStringValueDefaultTimout("name", "jk");
        String result2 = redisClient.getKeyStringValue("name");
        System.out.println(result2);

//        String result3 = redisClient.getKeyStringValue("jk:new"); System.out.println(result3);

//        redisClient.setTimoutByKey();

//        redisTemplate.keys("*");//会报错
    }

    @Test
    public void test_Hash() {
//        redisTemplate.opsForHash().delete()
        redisTemplate.delete("jk:new");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("jk", "jk1");
        System.out.println(map);
        redisTemplate.opsForHash().put("jk:new", "jk", "jk1");
//        redisUtil.hset("jk:new" , "jk" , "jk1");

//        redisTemplate.opsForHash().putAll("jk:new", map);

        Map mapResult = (HashMap) redisTemplate.opsForHash().entries("jk:new");
        System.out.println(mapResult);


    }
}
