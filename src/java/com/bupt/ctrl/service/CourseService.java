package com.bupt.ctrl.service;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.UserHasCourse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CourseService {
    //获得所有被审核通过的课程
    public List<Course>  getAllPass();

    //获得所有课程
    List<Course>  getAllCourse();

    //创建课程
    public int createCourse(Course course);

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

    //修改课程介绍
    public int updateCourseIntro(Course course);
  
    //更新审核状态
    int updataCoursePass(Course course);

    //删除课程
    void deleteCourse(Integer course_id);

    //修改课程封面
    public int updateCourseImage(Course course);

    public int getChapterNum(Integer course_id);

}
