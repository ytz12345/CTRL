package com.bupt.ctrl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.model.UserHasCourse;
import com.bupt.ctrl.service.CourseService;
import com.bupt.ctrl.service.UserHasCourseService;
import com.bupt.ctrl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserHasCourseService userHasCourseService;

    @Autowired
    private CourseService courseService;

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    private ModelAndView register(User user) {
        logger.info("into");

        userService.register(user);

        ModelAndView mav = new ModelAndView("redirect:/register-success.jsp");//指定跳转页面

        return mav;
    }

    //登录
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    private ModelAndView checkLogin(User user, HttpSession session){
        user = userService.checkLogin(user.getUserName(), user.getUserPassword());

        ModelAndView mav = new ModelAndView("redirect:/index.jsp");
        if(user != null){
            session.setAttribute("user",user);
        }else{
            mav.setViewName("redirect:/login_failure.jsp");//登录失败跳转到失败界面
        }

        return mav;
    }

    @RequestMapping(value = "/checkLogin_admin", method = RequestMethod.POST)
    @ResponseBody
    private ModelAndView checkLoginAdmin(User user, HttpSession session){
        user = userService.checkLoginAdmin(user.getUserName(), user.getUserPassword());

        ModelAndView mav = new ModelAndView("redirect:/allUsers");
        if(user != null){
            //mav.addObject("user", user);
            session.setAttribute("user",user);
        }else{
            mav.setViewName("redirect:/login_failure.jsp");//登录失败跳转到失败界面
        }

        return mav;
    }

    //用户更改密码
    @RequestMapping(value = "/passwordReset", method = RequestMethod.POST)
    @ResponseBody
    private ModelAndView passwordReset(@RequestParam(value = "oldPassword") String oldPassword,
                                       @RequestParam(value = "newPassword") String newPassword,
                                       @RequestParam(value = "uid") Integer uid,
                                       User user, HttpSession session){
        user = userService.getUserByID(uid);

        ModelAndView mav = new ModelAndView("redirect:/user-setting.jsp");
        if(!oldPassword.equals(user.getUserPassword())){
            mav.setViewName("redirect:/passwordReset_failure.jsp");//登录失败跳转到失败界面
        }else{
            user.setUserPassword(newPassword);
            userService.updateUser(user);
            session.setAttribute("user.userPassword",newPassword);
        }
        return mav;
    }

    @RequestMapping(value = "/introSubmit", method = RequestMethod.POST)
    @ResponseBody
    private ModelAndView passwordReset(@RequestParam(value = "userIntro") String userIntro,
                                       @RequestParam(value = "uid") Integer uid,
                                       User user, HttpSession session){
        user = userService.getUserByID(uid);

        ModelAndView mav = new ModelAndView("redirect:/user-setting.jsp");
        user.setUserIntro(userIntro);
        userService.updateUser(user);

        User tempUser = (User)session.getAttribute("user");
        tempUser.setUserIntro(userIntro);
        session.setAttribute("user",tempUser);

        return mav;
    }

    @RequestMapping(value = "/outLogin")
    @ResponseBody
    private ModelAndView outLogin(HttpSession session){
        ModelAndView mav = new ModelAndView("redirect:/index.jsp");

        session.removeAttribute("user");//注销

        if(session.getAttribute("user") == null){
            return mav;
        }else{
            mav.setViewName("redirect:/login_failure.jsp");
        }

        return mav;

    }

    @RequestMapping("/allUsers")
    public String getAllCourses(Model model) {
        List<User> allUsers = userService.getAllUser();
        model.addAttribute("users", allUsers);

        System.out.println("Yes, come here!");
         /*System.out.println(allCourses.size());
        for (Course i : allCourses) {
            System.out.println(i.toString());
        }
        */
        return "admin-user";
    }

    //订阅-提示登录
    @RequestMapping(value = "/course_login", method = RequestMethod.POST)
    @ResponseBody
    private ModelAndView courseLogin(@RequestParam(value = "course_id") int course_id, User user, HttpSession session){

        user = userService.checkLogin(user.getUserName(), user.getUserPassword());

        ModelAndView mav = new ModelAndView("login_failure");
        if(user != null){
            session.setAttribute("user",user);
            String c_id = String.valueOf(course_id);//转化course_id类型
            String success = "singleCourse?course_id=" + c_id;
            mav.setViewName("redirect:/" + success);//调用singleCourse
            return mav;
        }else{
            return mav;
        }
    }

    @RequestMapping("/teacher")
    public String getTeacher(@RequestParam(value="teacher_id") Integer teacher_id, Model model){
        User teacher = userService.getUserByID(teacher_id);
        model.addAttribute("teacher", teacher);
        List<UserHasCourse> userHasCourseList = userHasCourseService.getCourseByTeacher(teacher_id);
        System.out.println("teacher id: " + teacher_id);
        Integer allStudentNum = 0;
        for(int i = 0; i < userHasCourseList.size(); i ++){
            UserHasCourse userHasCourse = userHasCourseList.get(i);
            allStudentNum += userHasCourseService.getStudentNumByCourse(userHasCourse.getCourseCourseId());
        }
        model.addAttribute("allStudentNum", allStudentNum);
        System.out.println("allStudentNum: " + allStudentNum);
        model.addAttribute("courseNum", userHasCourseService.getCourseNumByTeacher(teacher_id));
        return "teacher";
    }
}