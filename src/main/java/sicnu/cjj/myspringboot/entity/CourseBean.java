package sicnu.cjj.myspringboot.entity;

public class CourseBean {

    private String name;  //用户名
    private String course_name;  //课程名
    private String class_num;//课程号

    public String getTeacher_name() {
        return name;
    }

    public void setTeacher_name(String name) {
        this.name = name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
    }
}
