package sicnu.cjj.myspringboot.mapper;

import sicnu.cjj.myspringboot.entity.ContentBean;
import sicnu.cjj.myspringboot.entity.CourseBean;

import java.util.List;

public interface CourseMapper {
    //查询教师课程表
    List<CourseBean> getAllUser(String account);

//    //查询教师评价内容
//    List<ContentBean> getAllContent(String name);
//    //查询最小的问题ques_id
//    int getques_id(String name);
//    //修改教师评价内容的每项分数
//    int updateContent(int id, String gradeid);
}
