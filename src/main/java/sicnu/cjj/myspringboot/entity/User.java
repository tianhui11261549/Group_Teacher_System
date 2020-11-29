package sicnu.cjj.myspringboot.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

//    private static final long serialVersionUID = 5237730257103305078L;

    private Integer user_id;
    private String account;  //账号
    private String password; //密码
    private String identity;  //身份证号
    private  String name; //用户名

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

