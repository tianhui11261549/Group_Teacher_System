package sicnu.cjj.myspringboot;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.mapper.UserMapper;
import sicnu.cjj.myspringboot.service.UserService;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class RedisTest {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串

    @Autowired
    RedisTemplate redisTemplate;//操作k-v都是对象

//    @Autowired
////    RedisCacheManager cacheManage;

    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;


//    @Test
//    public void  testRedis_userId(){
//
//    }

    /**
     * 测试redis五种数据类型
     * String（字符串）,list（列表）,set(集合），Hash(散列)，ZSet(有序集合)
     * opsForValue--操作字符串
     */

    @Test
    public void testRedis_userId(){
        //给Redis中保存了一个数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
        //接收缓存中数据
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
//        User userById = userMapper.getuser_id("2018191101");
        User userById =userService.Redis_getUser("2018191101");
        //方式1.set集合（默认）
        // redisTemplate.opsForValue().set("user-01",userById);
        //1.将数据已json的方式保存
        //（1）自己将对象转为json-用工具
        //(2)redisTemplate有默认的序列化规则，改变序列化器，将Bean输出  jdk序列化器切换成json序列化器
        //方式2.set集合（MyRedisConfig）
        serializableRedisTemplate.opsForValue().set("user",userById);
        User userTest = (User)  serializableRedisTemplate.opsForValue().get("redisCache");
        System.out.println(userTest);

    }
}
