package sicnu.cjj.myspringboot.controller;

import org.springframework.web.bind.annotation.RestController;
import sicnu.cjj.myspringboot.entity.ContentBean;
import sicnu.cjj.myspringboot.entity.CourseBean;
import sicnu.cjj.myspringboot.mapper.CourseMapper;
import sicnu.cjj.myspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sicnu.cjj.myspringboot.controller.UserController.account;

@Controller
public class CourseController {

    @Autowired
    UserService userService;




//
//    /**
//     *获取前端的登录账号
//     */
//    public String username;
//    @RequestMapping("/xuesheng")
//    @ResponseBody
//    public void juese(String name){
//        username = name;
//    }
//
//
//
//    /**
//     *显示评价教师列表  //ShowTeacherInfo
//     */
//    @RequestMapping("/users")
//    @ResponseBody
//    public List<CourseBean> showUsers(){
//
//        List<CourseBean> userList = userService.queryAllUser(username);
//        return userList;
//    }

//    /**
//     *给前端传参（评价内容）
//     */
//    @RequestMapping("/zhujie")
//    @ResponseBody
//    public List<ContentBean> showContent(String name){
//        List<ContentBean> contentList = userService.queryAllContent(name);
//        return contentList;
//    }
//
//    /**
//     *
//     */
//    @RequestMapping(value = "/tiaocha",method = RequestMethod.POST)
//    @ResponseBody
//    public Map grade(String grade){
//        String [] sgrade = grade.split(",");
//        int flag = userService.modifyGrade(sgrade);
//        Map<String,Object> map = new HashMap<String,Object>();
//        if(flag == 1){
//            map.put("msg","添加分数成功");
//            return map;
//        }else {
//            map.put("msg","添加分数失败");
//            return map;
//        }
//    }

}
