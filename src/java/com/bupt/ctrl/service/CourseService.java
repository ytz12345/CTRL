package com.bupt.ctrl.service;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.UserHasCourse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CourseService {
    //获得所有被审核通过的课程
    public List<Course>  getAllPass();

    //创建课程
    public void createCourse(Course course);

    //根据名字匹配来获得课程，用于搜索
    public List<Course> getCourseByName(String str);

    //根据课程id获得课程实例
    public Course getCourseByID(Integer course_id);

    //用户拥有课程（创建或订阅辅助方法）
    public int userHasCourse(UserHasCourse userHasCourse);

    //判断用户是否拥有课程
    public int teachOrStudy(Integer course_id, Integer user_id);

    //修改课程名
    public int updateCourseName(Course course);

    //修改课程名
    public int updateCourseIntro(Course course);

}
