package sicnu.cjj.myspringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.User;


import java.util.List;

@Repository
public interface UserMapper {
//    //输入account查询user
//    User findUser_id(String account);

    //添加用户
    @Insert("insert into users values(#{user_id},#{account}, #{password},#{identity},#{name})")
    void save(@Param("user_id")Integer user_id,@Param("account")String account,@Param("password")String password,
              @Param("identity")String identity,@Param("name")String name);


    //登录时查询用户
    User findUser(String account);

    //修改密码
    int updatepwd(String account,String newpwd);
    //验证身份证号
    String findIdentity(String account);

    //测试缓存
    User getuser_id(String account);
}
