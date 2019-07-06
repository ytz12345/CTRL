package com.bupt.ctrl.web;

import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/allcourses")
    public ModelAndView getCourse(){
        ModelAndView mav = new ModelAndView("courses");
        List<Course> courseList = courseService.getAllCourse();
        mav.addObject("courseList", courseList);
        mav.addObject("ccc", 1);
        System.out.println("!!!!!!!!!!!!" + courseList.size());
        return mav;
    }
}
