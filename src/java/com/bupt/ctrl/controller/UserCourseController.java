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

    //点击顶栏用户名时传入session中的用户id，进行多表连接查询到用户拥有的课程
    @RequestMapping("/getUserCourses")
    public String getUserCourses(@RequestParam(value="uid")Integer user_id, Model model){

        List<UserHasCourse> userHasCourses = userHasCourseService.getCourseById(user_id);
        //model.addAttribute("userHasCourses", userHasCourses);
        List<Course> courseList= new ArrayList();
        List<Course> courseListComing= new ArrayList();
        List<Course> courseListPass= new ArrayList();
        for(int i=0;i<userHasCourses.size();i++) {
            Course temp_courseList = courseService.getCourseByID(userHasCourses.get(i).getCourseCourseId());
            //已申请未通过课程
            if(temp_courseList.getCoursePass()==0)
                courseListComing.add(temp_courseList);
            //通过课程
            if(temp_courseList.getCoursePass()==1)
                courseList.add(temp_courseList);
            //已申请被拒绝课程
            if(temp_courseList.getCoursePass()==2)
                courseListPass.add(temp_courseList);
        }
        model.addAttribute("userCourses",courseList);
        model.addAttribute("userCoursesComing",courseListComing);
        model.addAttribute("userCoursesPass",courseListPass);

        return "user-homepage";
    }

}
