package com.bupt.ctrl.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.io.File;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/allCourses")
    public String getAllCourses(Model model) {
        List<Course> allCourses = courseService.getAllPass();
        model.addAttribute("courses", allCourses);
        System.out.println("Yes, come here!");
        System.out.println(allCourses.size());
        for (Course i : allCourses) {
            System.out.println(i.toString());
        }
        return "courses";
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public String createCourse(@RequestParam(value = "teacher_id")int teacher_id, @RequestParam("courseImageFile")CommonsMultipartFile courseImageFile, Course course) throws IOException {

        String courseImagePath = "/Users/yi/Desktop/upload/images/";//路径修改为服务器地址！！！
        String imagePath = courseImagePath + courseImageFile.getOriginalFilename();

        File newFile = new File(imagePath);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        courseImageFile.transferTo(newFile);

        course.setCourseImage(imagePath);
        course.setCoursePass(0);

        //这里获取时间并写入course

        courseService.createCourse(course);

        return "index";
    }



}
