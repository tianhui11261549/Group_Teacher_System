package sicnu.cjj.myspringboot;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@MapperScan("sicnu.cjj.myspringboot.mapper")
@Configuration
@EnableEncryptableProperties //启动数据库加密功能
@EnableCaching //开启基于注解的缓存
// 主要@Cacheable 可缓存方法  @CacheEvict 清除缓存  @CachePut 更新缓存

public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}
