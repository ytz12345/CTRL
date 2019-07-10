package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.dao.UserHasCourseMapper;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.model.UserHasCourse;
import com.bupt.ctrl.model.UserHasCourseExample;
import com.bupt.ctrl.service.UserHasCourseService;
import com.bupt.ctrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHasCourseServiceImpl implements UserHasCourseService {

    @Autowired
    UserHasCourseMapper userHasCourseMapper;

    @Autowired
    UserService userService;

    //根据传入的用户ID查询他的UserHasCourse列表
    public List<UserHasCourse> getCourseById(Integer user_id) {
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andUserUserIdEqualTo(user_id);
        return userHasCourseMapper.selectByExample(userHasCourseExample);
    }

    public void deleteUserHasCourse(Integer uid) {
        System.out.println("try delete");
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andUserUserIdEqualTo(uid);
        userHasCourseMapper.deleteByExample(userHasCourseExample);

        System.out.println("sd");
    }

    public Integer getStudentNumByCourse(Integer courseId) {
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andCourseCourseIdEqualTo(courseId);
        criteria.andUserTeachorstudyEqualTo(0);
        return userHasCourseMapper.countByExample(userHasCourseExample);
    }

    public Integer getCourseNumByTeacher(Integer teacherId) {
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andUserTeachorstudyEqualTo(1);
        criteria.andUserUserIdEqualTo(teacherId);
        return userHasCourseMapper.countByExample(userHasCourseExample);
    }

    public List<UserHasCourse> getCourseByTeacher(Integer teacherId) {
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andUserTeachorstudyEqualTo(1);
        criteria.andUserUserIdEqualTo(teacherId);
        return userHasCourseMapper.selectByExample(userHasCourseExample);
    }

    public User getTeacherByCourse(Course course) {
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andCourseCourseIdEqualTo(course.getCourseId());
        List<UserHasCourse> userHasCourseList = userHasCourseMapper.selectByExample(userHasCourseExample);

        User user;
        for (UserHasCourse userHasCourse : userHasCourseList) {
            user = userService.getUserByID(userHasCourse.getUserUserId());
            if (user != null && user.getUserIdentity() == 2)
                return user;
        }

        return null;
    }
}