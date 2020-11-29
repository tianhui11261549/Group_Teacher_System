package sicnu.cjj.myspringboot.service;

import org.springframework.cache.annotation.Cacheable;
import sicnu.cjj.myspringboot.entity.ContentBean;
import sicnu.cjj.myspringboot.entity.CourseBean;
import sicnu.cjj.myspringboot.entity.User;

import java.util.List;

public interface UserService {

    //调试user_id
    User getUser_id (String account);

    //redis注解版测试
    User Redis_getUser(String account);

    //用户登录
    User getUser(String account);
    //忘记密码
    int resetpwd(String account,String newpwd);
    //验证身份证号
    String isIdentity (String account);

    //学生子系统

    //课程表的查询
    List<CourseBean> queryAllUser(String username);


//    //评价内容的查询
//    List<ContentBean> queryAllContent(String name);
//    //填写教师每项分数
//    int modifyGrade(String[] grade);
}
