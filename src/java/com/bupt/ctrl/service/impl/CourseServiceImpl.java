package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.ChapterMapper;
import com.bupt.ctrl.dao.CourseMapper;
import com.bupt.ctrl.dao.UserHasCourseMapper;
import com.bupt.ctrl.model.*;
import com.bupt.ctrl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    UserHasCourseMapper userHasCourseMapper;

    @Autowired
    ChapterMapper chapterMapper;
    //获得所有课程
    public List<Course> getAllPass() {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursePassEqualTo(1);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Course> getAllCourse(){
        CourseExample courseExample = new CourseExample();
        return courseMapper.selectByExample(courseExample);
    }


    @Override
    //将课程信息插入course表
    public int createCourse(Course course){

        courseMapper.insert(course);
        return 1;
    }

    public List<Course> getCourseByName(String str) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseNameLike("%" + str + "%");
        criteria.andCoursePassEqualTo(1);
        return courseMapper.selectByExample(courseExample);
    }

    @Override
    //设置用户拥有课程
    public int userHasCourse(UserHasCourse userHasCourse){
        userHasCourseMapper.insert(userHasCourse);
        return 1;
    };

    //判断用户是否拥有课程
    public int teachOrStudy(Integer course_id, Integer user_id){
        int tos = 100;//学生未订阅
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andCourseCourseIdEqualTo(course_id);
        criteria.andUserUserIdEqualTo(user_id);
        List<UserHasCourse> list = userHasCourseMapper.selectByExample(userHasCourseExample);

        if(list.size() == 0) return tos;


        UserHasCourse userHasCourse = list.get(0);

        if(userHasCourse.getUserTeachorstudy() == 1){
            tos = 1;//教师拥有课程修改权限
        }else {
            tos = 0;//学生已订阅课程
        }

        return tos;

    }

    public Course getCourseByID(Integer course_id){
        return courseMapper.selectByPrimaryKey(course_id);
    }

    //修改课程名
    public int updateCourseName(Course course){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();

        criteria.andCourseIdEqualTo(course.getCourseId());
        courseMapper.updateByExampleSelective(course,courseExample);
        return 1;
    }

    //修改课程名
    public int updateCourseIntro(Course course){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();

        criteria.andCourseIdEqualTo(course.getCourseId());
        courseMapper.updateByExampleSelective(course,courseExample);
        return 1;
    }

    public int updataCoursePass(Course course){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseIdEqualTo(course.getCourseId());
        courseMapper.updateByExampleSelective(course,courseExample);
        return 1;
    }

    //修改课程封面
    public int updateCourseImage(Course course){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();

        criteria.andCourseIdEqualTo(course.getCourseId());
        courseMapper.updateByExampleSelective(course,courseExample);
        return 1;
    }

    public void deleteCourse(Integer course_id){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseIdEqualTo(course_id);
        courseMapper.deleteByExample(courseExample);
    }

    public int getChapterNum(Integer course_id){
        ChapterExample chapterExample = new ChapterExample();
        ChapterExample.Criteria criteria = chapterExample.createCriteria();
        criteria.andCourseCourseIdEqualTo(course_id);
        return chapterMapper.countByExample(chapterExample);
    }
}
