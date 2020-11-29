package sicnu.cjj.myspringboot.mapper;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sicnu.cjj.myspringboot.entity.User;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import java.io.Serializable;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching //开启基于注解的缓存
public class test {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        User Ruser = userMapper.getuser_id("2018110442");
        System.out.println(Ruser);
    }


//   //测试是否可以返回user_id
//    @Test
//    public void getUer_id(){
//        User userid = userMapper.getuser_id(1);
//        System.out.println(userid);
//    }

//    @Test
//    public void Test1(){
//        String version1 = SpringBootVersion.getVersion();
//        System.out.println(version1); //2.3.5.RELEASE
//    }
}
