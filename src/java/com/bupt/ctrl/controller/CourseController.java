package com.bupt.ctrl.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.service.CourseService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/allCourses")
    public String getAllCourses(Model model) {
        List<Course> allCourses = courseService.getAllPass();
        model.addAttribute("courses", allCourses);
        /*
        System.out.println("Yes, come here!");
        System.out.println(allCourses.size());
        for (Course i : allCourses) {
            System.out.println(i.toString());
        }
        */
        return "courses";
    }

    @RequestMapping("/selectCoursesByName")
    public String getSelectedCourses(@RequestParam("str") String str, Model model) {
        List<Course> selectedCourses = courseService.getCourseByName(str);
        model.addAttribute("courses", selectedCourses);
        return "selectedCourses";
    }
}
