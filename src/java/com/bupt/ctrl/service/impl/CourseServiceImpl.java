package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.dao.UserHasCourseMapper;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.CourseExample;
import com.bupt.ctrl.service.CourseService;
import com.bupt.ctrl.model.UserHasCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserHasCourseMapper userHasCourseMapper;
    //获得所有课程
    public List<Course> getAllPass() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursePassEqualTo(1);
        return courseMapper.selectByExample(courseExample);
    }

    //将课程信息插入course表
    public void createCourse(Course course){
        courseMapper.insert(course);
    }

    public List<Course> getCourseByName(String str) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseNameLike("%" + str + "%");
        criteria.andCoursePassEqualTo(1);
        return courseMapper.selectByExample(courseExample);
    }

    //设置用户拥有课程
    public int userHasCourse(UserHasCourse userHasCourse){
        userHasCourseMapper.insert(userHasCourse);
        return 1;
    };

    public Course getCourseByID(Integer course_id){
        return courseMapper.selectByPrimaryKey(course_id);
    }
}
