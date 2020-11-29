package sicnu.cjj.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sicnu.cjj.myspringboot.entity.TeacherClass;
import sicnu.cjj.myspringboot.entity.TeacherFile;

import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    //查询教师档案信息，返回教师档案信息类
     @RequestMapping("getfile")
     private TeacherFile getteacherfile(String username){
         // TODO: 2020/11/17
         return null;
     }

    //修改教师档案信息，返回修改失败或成功
    @RequestMapping("updatefile")
    private boolean updateteacherfile(TeacherFile teacherFile){
        // TODO: 2020/11/17
        return true;
    }

    //查看教学成绩，参数：教师，课程，班级  返回教师授课列表
    @RequestMapping("getteacherclasslist")
    private List<TeacherClass> getteacherclasslist(){
        // TODO: 2020/11/17
        return null;
    }

    //查看班级有关学生详细评价以及各平均分
    @RequestMapping("getteacherclass")
    private String getteacherclass(){
        // TODO: 2020/11/17
         return null;
    }

    //查看评价同行列表
    @RequestMapping("getteacherlist")
    private String getteacherlist(){
        // TODO: 2020/11/17
        return null;
    }

    //评价同行，填写表格
    @RequestMapping("addteachertable")
    private String addteachertable(){
        // TODO: 2020/11/17
        return null;
    }

}
