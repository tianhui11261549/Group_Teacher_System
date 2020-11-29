package sicnu.cjj.myspringboot;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class jasypt_InsrtPwd_Test {
    /**
     * jasypt加密数据库连接密码，可以不用解密
     */
    @Test
    public void InsertPasswordTest(){
        BasicTextEncryptor textEncryptor= new BasicTextEncryptor();
        //加密所需的盐
        textEncryptor.setPassword("sb01");
        //要加密的数据
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("123456");

        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
