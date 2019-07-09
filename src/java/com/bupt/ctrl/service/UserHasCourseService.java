package com.bupt.ctrl.service;

import com.bupt.ctrl.model.UserHasCourse;

import java.util.Map;

import java.util.List;

//根据传入的用户ID查询他的UserHasCourse列表
public interface UserHasCourseService {

    public List<UserHasCourse> getCourseById(Integer user_id);

    //获取当前课程学生数量
    Integer getStudentNumByCourse(Integer courseId);

    //获取Teacher教的课程数量
    Integer getCourseNumByTeacher(Integer teacherId);

    //获取Teacher教的所有课程
    List<UserHasCourse> getCourseByTeacher(Integer teacherId);
}