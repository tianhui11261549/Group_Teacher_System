package sicnu.cjj.myspringboot.service.impl;

import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sicnu.cjj.myspringboot.entity.ContentBean;
import sicnu.cjj.myspringboot.entity.CourseBean;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.mapper.CourseMapper;
import sicnu.cjj.myspringboot.mapper.UserMapper;
import sicnu.cjj.myspringboot.service.UserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
@Service
//@CacheConfig(cacheManager = "cacheManager", cacheNames = "user", keyGenerator = "userKeyGen")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //修改Autowired 为Resourse
    @Resource
    private CourseMapper courseMapper;





   @Override
    public User getUser_id (String account){
        System.out.println("查询"+account+"用户");
        return userMapper.getuser_id(account);
    }
    @Override
    @Transactional
    @Cacheable(cacheManager = "cacheManager", value = "user",key="'user-'+#account")  //keyGenerator = "keyGenerator"属性可以自定义前缀
    public User Redis_getUser (String account){
        System.out.println("Redis_getUser查询"+account+"用户");
        return userMapper.getuser_id(account);
    }

    @Override
    public User getUser(String account) {
        System.out.println("查询"+account+"账号");
        return userMapper.findUser(account);
    }
    @Override
    public int resetpwd(String account,String newpwd){
        return userMapper.updatepwd(account,newpwd);
    }
    @Override
    public  String isIdentity(String account){
        return userMapper.findIdentity(account);
    }



    //学生子系统
    @Override
    @Transactional
    @Cacheable(cacheManager = "cacheManager", value = "user",key="'stu_teacher-list'+#account")
    public List<CourseBean> queryAllUser(String account) {
       List<CourseBean> list= courseMapper.getAllUser(account);
        return list;
    }

//    @Override
//    public List<ContentBean> queryAllContent(String name) {
//        username = name;
//        return courseMapper.getAllContent(name);
//    }
//    @Override
//    public int modifyGrade(String[] grade){
//        int aFlag = 0 ;
//        int i,ques_id;
//        ques_id = courseMapper.getques_id(username);
//        for(i=0;i<grade.length;i++){
//            aFlag = courseMapper.updateContent(i+ques_id,grade[i]);
//        }
//        return aFlag;
//    }

}
