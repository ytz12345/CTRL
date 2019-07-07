package com.bupt.ctrl.service;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.model.Course;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CourseService {
    //获得所有被审核通过的课程
    public List<Course>  getAllPass();

    //根据名字匹配来获得课程，用于搜索
    public List<Course> getCourseByName(String str);

    //根据课程id获得课程实例
    public Course getCourseByID(Integer course_id);
}
