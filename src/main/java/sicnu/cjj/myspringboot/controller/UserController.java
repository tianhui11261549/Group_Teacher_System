package sicnu.cjj.myspringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import sicnu.cjj.myspringboot.entity.CourseBean;
import sicnu.cjj.myspringboot.entity.CourseBean;
import sicnu.cjj.myspringboot.entity.LoginInfo;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.mapper.UserMapper;
import sicnu.cjj.myspringboot.result.Result;
import sicnu.cjj.myspringboot.result.ResultGenerator;
import sicnu.cjj.myspringboot.service.UserService;
import sicnu.cjj.myspringboot.service.impl.LoginServiceImpl;
import sicnu.cjj.myspringboot.util.RedisUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
//@CrossOrigin//跨域注解
@RequestMapping("user")
public class UserController {
   //全局变量账号
    public static String account;


    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserService userService;

//    @Autowired
//    private PicVerifyAction picVerifyAction;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DNS_InsertPwd dns_insertPwd;

    @Resource
    LoginServiceImpl loginServiceImpl;



    /**,
     * 添加用户
     */
    @RequestMapping("AddUser")
    public String AddUser(Integer user_id,String account,String password,String identity,String name) {
       //调用工具类DNS_InsertPwd的加密方法加密密码
        String In_pwd = dns_insertPwd.encryptBasedDes(password);
        userMapper.save(user_id,account,In_pwd,identity,name);
        return "添加用户成功";
    }


    /**
     *redis缓存实例 查询用户
     */
    @RequestMapping("getUser_id")
    public String getUser_id(String account){
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(account);
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(account);
            System.out.println("从缓存获取的数据"+ object);
            str = object.toString();
        }else{
            //从数据库中获取信息
            System.out.println("从数据库中获取数据");
            User user= userService.getUser_id(account);
            System.out.println(user);
            str=user.toString();
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(account,str,10L, TimeUnit.MINUTES);
            System.out.println("数据插入缓存： 数据内容" + str);

        }
        return str;
//        return userService.getUser_id(account);
    }



    /**
     * 缓存注解的方法的实现
     */
    @RequestMapping("Redis")
    public User Redis(String account){
        return userService.Redis_getUser(account);
    }

    /**
     *用户登录
     */
    @RequestMapping("login")
    public Result getUser(@RequestBody LinkedHashMap<String,String> params, Model model){

        System.out.println("用户输入密码是："+params.get("password"));
        account=params.get("account");

        User userDB = userMapper.findUser(params.get("account"));

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(params.get("account"),userDB.getPassword());

        System.out.println("usertokende 的值"+token.getUsername());
        //验证密码是否解密
        String pwdDB = dns_insertPwd.decryptBasedDes(userDB.getPassword());
        System.out.println("解密后的数据库密码："+pwdDB);

        if(pwdDB.equals(params.get("password"))){
            try{
                subject.login(token); //执行登录方法，如果没有异常就ok,执行了UserRealm的认证方法
                Session session = subject.getSession();
                session.setAttribute("account",params.get("account"));
                LoginInfo loginInfo= loginServiceImpl.getLoginInfo();
                Result result=ResultGenerator.genSuccessResult(loginInfo);
                return result;
            }catch(UnknownAccountException e){
                model.addAttribute("msg","用户名错误");
                return ResultGenerator.genFailResult("用户名错误");
                    //return "login";
            }catch(IncorrectCredentialsException e){
                model.addAttribute("msd","cs");
//                   return "密码错误";
                return ResultGenerator.genFailResult("login");
            }
        }else{
            return ResultGenerator.genFailResult("密码输入错误");
        }
    }
    /**
     * 学生页面返回教师信息列表
     */
    @RequestMapping("xuesheng")
    public List<CourseBean> showUsers(){
        List<CourseBean> userList = userService.queryAllUser("2018110442");
        return userList;
    }


    /**
     *忘记密码
     */
    @RequestMapping("resetpwd")
    public  Result ResetPwd(@RequestBody LinkedHashMap<String,String> params){
            String isIdent = userService.isIdentity(params.get("account"));
            //为新密码加密
            String dns_newpwd = dns_insertPwd.encryptBasedDes(params.get("newpwd"));
            //修改数据库密码
            int flag=userService.resetpwd(params.get("account"),dns_newpwd);
            if(flag==1){
                System.out.println("修改密码成功");
                return ResultGenerator.genSuccessResult();

            }else{
                return ResultGenerator.genFailResult("修改密码失败");
            }

    }



    @RequestMapping("add")
    public User Add(String account){
        System.out.println("执行了add函数");
        return userService.getUser(account);
    }
    @RequestMapping("tologin")
    public String Tologin(){
        return "没有权限login";
    }
}
