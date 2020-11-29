package sicnu.cjj.myspringboot.entity;

import com.google.inject.internal.asm.$Type;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherFile {
    private Integer user_id;
    private String name;
    private String sex;
    private String education; //学历
    private String title;    //职称
    private Date birthdate;   //出生日期
    private  String worktime;  //工作时间
    private String school;     //毕业学校
    private String politicalface;  //政治面目
    private Date granttime;    //职称授予时间
    private double teacher_score;  //老师得分
    private  Integer teachinghours; //累计授课学时

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPoliticalface() {
        return politicalface;
    }

    public void setPoliticalface(String politicalface) {
        this.politicalface = politicalface;
    }

    public Date getGranttime() {
        return granttime;
    }

    public void setGranttime(Date granttime) {
        this.granttime = granttime;
    }

    public double getTeacher_score() {
        return teacher_score;
    }

    public void setTeacher_score(double teacher_score) {
        this.teacher_score = teacher_score;
    }

    public Integer getTeachinghours() {
        return teachinghours;
    }

    public void setTeachinghours(Integer teachinghours) {
        this.teachinghours = teachinghours;
    }
}
