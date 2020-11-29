package sicnu.cjj.myspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sicnu.cjj.myspringboot.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddUserTest {

    @Autowired
    UserController userController;

    /**
     * 采用DNS对数据库存储的敏感信息，eg:用户名密码，提高信息安全度
     */
    @Test
    public void InsertPasswordTest(){
        //已添加
//        userController.AddUser(1,"2018110442","tianhui1@","640381199911261549","田荟");
//        userController.AddUser(2,"2018110310","tianhui2@","120101199003077450","梅珊");
//        userController.AddUser(3,"2018110441","lyf1234.","120101199003070275","廖雪花");
//        userController.AddUser(4,"2018110109","lyf12345.","120101199003073994","苏利");
//        userController.AddUser(5,"2018110219","cjj1234@","130102199004073601","田荟");
//        userController.AddUser(6,"2020302040","cjj12345@","510104199003079079","小熊");
//        userController.AddUser(7,"2019300101","cxx1234%","640381199911261547","林宇");
//        userController.AddUser(8,"2017021810","cxx12345%","510104199003078738","林泉");

        //未添加
//        userController.AddUser(9,"2020112676","th986634/","510104199003077196","吴亮");
//        userController.AddUser(10,"2020102670","th9866@@","510104199003076417","苏晗");


    }

}
