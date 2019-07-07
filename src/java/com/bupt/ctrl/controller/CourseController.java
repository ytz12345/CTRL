package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Chapter;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.UserHasCourse;
import com.bupt.ctrl.service.ChapterService;
import com.bupt.ctrl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.io.File;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    ChapterService chapterService;

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

    //创建课程
    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public String createCourse(@RequestParam(value = "teacher_id")int teacher_id, @RequestParam("courseImageFile")CommonsMultipartFile courseImageFile, Course course, HttpServletRequest request) throws IOException {

        UserHasCourse userHasCourse = new UserHasCourse();
        String courseImagePath = request.getServletContext().getRealPath("/upload/images/");//路径修改为服务器地址！！！
        String filename = courseImageFile.getOriginalFilename();//获取文件名
        String imagePath = courseImagePath + filename;//图像上传完整路径

        File imageFile = new File(courseImagePath,filename);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）

        if(!imageFile.getParentFile().exists()){
            imageFile.getParentFile().mkdirs();
        }

        courseImageFile.transferTo(imageFile);

        course.setCourseImage(imagePath);
        course.setCoursePass(0);

        courseService.createCourse(course);//创建课程-添加数据进course表

        userHasCourse.setUserUserId(teacher_id);//传入课程创建人id
        userHasCourse.setCourseCourseId(course.getCourseId());//传入课程id
        userHasCourse.setUserTeachorstudy(1);//设置拥有类型为：teach

        int flag = 0;
        flag = courseService.userHasCourse(userHasCourse);//创建课程-添加数据进user_has_course表

        if(flag == 1){
            return "index";
        }else{
            return "course-create";//待修改
        }
    }



    @RequestMapping("/selectCoursesByName")
    public String getSelectedCourses(@RequestParam("str") String str, Model model) {
        List<Course> selectedCourses = courseService.getCourseByName(str);
        model.addAttribute("courses", selectedCourses);
        return "selectedCourses";
    }

    @RequestMapping("/singleCourse")
    public String getSingleCourse(@RequestParam(value= "course_id") int course_id, Model model){
        Course course = courseService.getCourseByID(course_id);
        model.addAttribute("course", course);
        List<Chapter> chapterList = chapterService.getChapterOfCourse(course_id);
        model.addAttribute("chapterList", chapterList);
        return "single-courses";
    }
}
