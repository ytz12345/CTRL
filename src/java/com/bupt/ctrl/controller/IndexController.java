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
public class IndexController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String getIndex(Model model){
        List<Course> firstTwoCourses = new ArrayList<>();
        List<Course> sixCourses = new ArrayList<>();
        List<Course> courseList = courseService.getAllPass();
        for(int i = 0; i < Math.min(2, courseList.size()); i ++) firstTwoCourses.add(courseList.get(i));
        for(int i = 0; i < Math.min(6, courseList.size()); i ++) sixCourses.add(courseList.get(i));
        model.addAttribute("courseList", firstTwoCourses);
        model.addAttribute("sixCourses", sixCourses);
        List<User> userList = userService.getTeachers();
        model.addAttribute("teachers", userList);
        return "index_2";
    }
}
