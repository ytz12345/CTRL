package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.service.CourseService;
import com.bupt.ctrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class                                IndexController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String getIndex(Model model){
        List<CourseAndTeacher> firstTwoCoursesAndTeacher = new ArrayList<>();
        List<CourseAndTeacher> sixCoursesAndTeacher = new ArrayList<>();
        List<Course> courseList = courseService.getAllPass();
        for(int i = 0; i < Math.min(2, courseList.size()); i ++){
            Course course = courseList.get(i);
            User teacher  = userService.getTeacherByName(course.getCourseTeacher());
            CourseAndTeacher courseAndTeacher = new CourseAndTeacher(course, teacher);
            firstTwoCoursesAndTeacher.add(courseAndTeacher);
        }
        for(int i = 0; i < Math.min(6, courseList.size()); i ++){
            Course course = courseList.get(i);
            User teacher  = userService.getTeacherByName(course.getCourseTeacher());
            CourseAndTeacher courseAndTeacher = new CourseAndTeacher(course, teacher);
            sixCoursesAndTeacher.add(courseAndTeacher);
        }
        model.addAttribute("firstTwoCoursesAndTeacher", firstTwoCoursesAndTeacher);
        model.addAttribute("sixCoursesAndTeacher", sixCoursesAndTeacher);
        List<User> userList = userService.getTeachers();
        model.addAttribute("teachers", userList);
        return "index_2";
    }

    @RequestMapping("/about")
    public String getAbout(Model model){
        List<User> teacherlist = userService.getTeachers();
        List<User> teacherDisplayList = new ArrayList<>();
        for(int i = 0; i < Math.min(4, teacherlist.size()); i ++){
            teacherDisplayList.add(teacherlist.get(i));
        }
        model.addAttribute("teacherDisplayList", teacherDisplayList);
        return "about";
    }
}
