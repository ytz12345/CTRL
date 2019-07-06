package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements com.bupt.ctrl.service.CourseService{
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse(){
        return courseMapper.selectByExample(null);
    }
}
