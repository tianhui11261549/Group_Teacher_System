package sicnu.cjj.myspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BusinessManager")
public class BusinessManagerController {

    //业务管理员教师档案管理部分
    /**
     * 添加教师档案
     */
    @RequestMapping("AddTeacherFile")
    public void AddTeacherFile(){

    }
    /**
     * 删除教师档案
     */
    @RequestMapping("DelectTeacherFile")
    public void DelectTeacherFile(){

    }

    /**
     * 返回教师信息列表（主界面）
     */
    @RequestMapping("TeacherList")
    public void TeacherList(){

    }

    /**
     * 根据教师号，教师姓名查询教师档案(审核页面)--考虑模糊查询  修改原型页面相关
     */
    @RequestMapping("SearchTeacher")
    public void SearchTeacher(){

    }
    /**
     * 查看教师档案详情
     */
    @RequestMapping("LookTeacherInfo")
    public void LookTeacherInfo(){

    }


    /**
     * 审核教师修改档案申请
     */
    @RequestMapping("AuditUpdateTeacherFile")
    public void AuditUpdateTeacherFile(){

    }

}
