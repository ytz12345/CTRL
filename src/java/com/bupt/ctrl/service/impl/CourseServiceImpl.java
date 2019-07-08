package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.CourseExample;
import com.bupt.ctrl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getAllPass() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursePassEqualTo(1);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Course> getCourseByName(String str) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseNameLike("%" + str + "%");
        criteria.andCoursePassEqualTo(1);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public Course getCourseByID(Integer course_id){
        return courseMapper.selectByPrimaryKey(course_id);
    }
}
