package com.bupt.ctrl.controller;

import com.bupt.ctrl.common.commonPath;
import com.bupt.ctrl.model.Chapter;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.model.UserHasCourse;
import com.bupt.ctrl.service.ChapterService;
import com.bupt.ctrl.service.CourseService;
import com.bupt.ctrl.service.UserHasCourseService;
import com.bupt.ctrl.service.UserService;
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
import java.util.ArrayList;
import java.util.List;
import java.io.File;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    UserService userService;
    @Autowired
    UserHasCourseService userHasCourseService;

    @RequestMapping("/allCourses")
    public String getAllCourses(Model model) {
        List<Course> allCourses = courseService.getAllPass();
        List<CourseAndTeacher> courseAndTeacherList = new ArrayList<>();
        for(int i = 0; i < allCourses.size(); i ++){
            Course course = allCourses.get(i);
            User teacher  = userService.getTeacherByName(course.getCourseTeacher());
            CourseAndTeacher courseAndTeacher = new CourseAndTeacher(course, teacher);
            courseAndTeacherList.add(courseAndTeacher);
        }
        model.addAttribute("courseAndTeacher", courseAndTeacherList);
        /*
        System.out.println("Yes, come here!");
        System.out.println(allCourses.size());
        for (Course i : allCourses) {
            System.out.println(i.toString());
        }
        */
        return "courses";
    }

    @RequestMapping("/adminCourses")
    public String adminAllCourses(Model model){
        List<Course> allCourses = courseService.getAllCourse();
        model.addAttribute("courses", allCourses);
        return "admin-course";
    }

    //通过课程，重新上架
    @RequestMapping("/coursePass")
    public String CoursePass(@RequestParam("course_id")Integer id,Model model){
        Course course = new Course();
        course.setCourseId(id);
        course.setCoursePass(1);
        courseService.updataCoursePass(course);
        List<Course> allCourses = courseService.getAllCourse();
        model.addAttribute("courses", allCourses);
        return "admin-course";
    }

    //不通过，下架课程
    @RequestMapping("/courseDontPass")
    public String CourseDontPass(@RequestParam("course_id")Integer id,Model model){
        Course course = new Course();
        course.setCourseId(id);
        course.setCoursePass(2);
        courseService.updataCoursePass(course);
        List<Course> allCourses = courseService.getAllCourse();
        model.addAttribute("courses", allCourses);
        return "admin-course";
    }

    //删除课程

    //创建课程
    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public String createCourse(@RequestParam(value = "teacher_id")int teacher_id, @RequestParam("courseImageFile")CommonsMultipartFile courseImageFile, Course course, HttpServletRequest request) throws IOException {

        UserHasCourse userHasCourse = new UserHasCourse();
        String courseImagePath = commonPath.imagePath;//路径修改为服务器地址！！！

        String filename = courseImageFile.getOriginalFilename();//获取文件名
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);//获取原文件后缀名

        course.setCourseImage(courseImagePath + filename);
        course.setCoursePass(0);
        int flag = 0;
        flag = courseService.createCourse(course);//创建课程-添加数据进course表

        String preffix = String.valueOf(course.getCourseId());
        String realImageName = preffix + "." + suffix;
        String imagePath = courseImagePath + realImageName;//图像上传完整路径

        File imageFile = new File(imagePath);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）

        if(!imageFile.getParentFile().exists()){
            imageFile.getParentFile().mkdirs();
        }

        courseImageFile.transferTo(imageFile);
        /*try {
            courseImageFile.transferTo(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        if(flag == 1 && imageFile.exists()){
            userHasCourse.setUserUserId(teacher_id);//传入课程创建人id
            userHasCourse.setCourseCourseId(course.getCourseId());//传入课程id
            userHasCourse.setUserTeachorstudy(1);//设置拥有类型为：teach

            course.setCourseImage(imagePath);
            courseService.updateCourseImage(course);
            courseService.userHasCourse(userHasCourse);//创建课程-添加数据进user_has_course表

            return "index";
        }
            return "course-create";//待修改

    }

    //订阅
    @RequestMapping("/addToCart")
    public ModelAndView addToCart(@RequestParam(value = "course_id") int course_id, @RequestParam(value = "student_id") int student_id){

        UserHasCourse userHasCourse = new UserHasCourse();
        userHasCourse.setUserTeachorstudy(0);//学生订阅-设置为0
        userHasCourse.setCourseCourseId(course_id);//写入课程id
        userHasCourse.setUserUserId(student_id);//写入学生id

        ModelAndView mav = new ModelAndView("订阅失败");

        int flag = 0;
        flag = courseService.userHasCourse(userHasCourse);

        if(flag == 1){
            String c_id = String.valueOf(course_id);//转化course_id类型
            String success = "singleCourse?course_id=" + c_id;
            mav.setViewName("redirect:/" + success);//调用singleCourse
            return mav;
        }

        return mav;
    }


    @RequestMapping("/selectCoursesByName")
    public String getSelectedCourses(@RequestParam("str") String str, Model model) {
        List<Course> selectedCourses = courseService.getCourseByName(str);
        model.addAttribute("courses", selectedCourses);
        return "selectedCourses";
    }

    @RequestMapping("/singleCourse")
    public String getSingleCourse(@RequestParam(value= "course_id") int course_id, Model model, HttpServletRequest requset){
        Course course = courseService.getCourseByID(course_id);
        model.addAttribute("course", course);
        List<Chapter> chapterList = chapterService.getChapterOfCourse(course_id);
        model.addAttribute("chapterList", chapterList);
        int chapterNum = courseService.getChapterNum(course_id);
        model.addAttribute("chapterNum", chapterNum);

        int tos = -1;
        User user = (User)requset.getSession().getAttribute("user");

        if(user == null){
            System.out.println("user is null");
        }else{
            tos = courseService.teachOrStudy(course_id, user.getUserId());
        }
        User teacher  = userService.getTeacherByName(course.getCourseTeacher());
        model.addAttribute("teacher", teacher);

        Integer studentNum = userHasCourseService.getStudentNumByCourse(course_id);
        model.addAttribute("studentNum", studentNum);

        model.addAttribute("tos",tos);
        return "single-courses";
    }

    //修改课程名
    @RequestMapping("/modifyCourseName")
    public ModelAndView modifyCourseName(@RequestParam(value = "course_id") int course_id,@RequestParam(value = "newCourseName") String newCourseName){

        ModelAndView mav = new ModelAndView("更改失败");

        int flag = 0;

        Course course = new Course();
        course.setCourseName(newCourseName);
        course.setCourseId(course_id);
        flag = courseService.updateCourseName(course);

        if(flag == 1){
            String c_id = String.valueOf(course_id);//转化course_id类型
            String success = "singleCourse?course_id=" + c_id;
            mav.setViewName("redirect:/" + success);//调用singleCourse
            return mav;
        }

        return mav;
    }

    //修改课程介绍
    @RequestMapping("/modifyCourseIntro")
    public ModelAndView modifyCourseIntro(@RequestParam(value = "course_id") int course_id,@RequestParam(value = "newCourseIntro") String newCourseIntro){

        ModelAndView mav = new ModelAndView("更改失败");

        int flag = 0;

        Course course = new Course();

        course.setCourseIntro(newCourseIntro);
        course.setCourseId(course_id);
        flag = courseService.updateCourseIntro(course);

        if(flag == 1){
            String c_id = String.valueOf(course_id);//转化course_id类型
            String success = "singleCourse?course_id=" + c_id;
            mav.setViewName("redirect:/" + success);//调用singleCourse
            return mav;
        }

        return mav;
    }

    //更改课程封面
    @RequestMapping(value = "/modifyCourseImage", method = RequestMethod.POST)
    public ModelAndView modifyCourseImage(@RequestParam(value = "course_id")int course_id, @RequestParam("newCourseImage")CommonsMultipartFile newCourseImageFile, HttpServletRequest request) throws IOException {

        ModelAndView mav = new ModelAndView("更改失败");

        Course course = courseService.getCourseByID(course_id);
        String imagePath = course.getCourseImage();

        File imageFile = new File(imagePath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）

        if(!imageFile.getParentFile().exists()){
            imageFile.getParentFile().mkdirs();
        }

        newCourseImageFile.transferTo(imageFile);

        if(imageFile.exists()){

            String c_id = String.valueOf(course_id);//转化course_id类型
            String success = "singleCourse?course_id=" + c_id;
            mav.setViewName("redirect:/" + success);//调用singleCourse
            return mav;
        }
        return mav;
    }


}
