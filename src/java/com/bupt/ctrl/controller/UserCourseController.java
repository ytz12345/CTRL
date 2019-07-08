package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.UserHasCourse;
import com.bupt.ctrl.service.CourseService;
import com.bupt.ctrl.service.UserHasCourseService;
import com.bupt.ctrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserCourseController {

    @Autowired
    UserHasCourseService userHasCourseService;

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @RequestMapping("/getUserCourses")
    public String getUserCourses(@RequestParam(value="uid")Integer user_id, Model model){

        List<UserHasCourse> userHasCourses = userHasCourseService.getCourseById(user_id);
        model.addAttribute("userHasCourses", userHasCourses);
        List<Course> courseList= new ArrayList();
        for(int i=0;i<userHasCourses.size();i++) {
            Course temp_courseList = courseService.getCourseByID(userHasCourses.get(i).getCourseCourseId());
            courseList.add(temp_courseList);
        }
        model.addAttribute("userCourses",courseList);
        System.out.println("Show userHasCourses : " + userHasCourses);
        System.out.println("Show userCourses : " + courseList);
        return "user-homepage";
    }

}
