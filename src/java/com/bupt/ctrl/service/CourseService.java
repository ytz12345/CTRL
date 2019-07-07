package com.bupt.ctrl.service;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.model.Course;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CourseService {
    public List<Course>  getAllPass();
    void createCourse(Course course);
}
