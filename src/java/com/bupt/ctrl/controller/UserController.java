package com.bupt.ctrl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bupt.ctrl.model.User;
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
        return "admin-user";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("uid")Integer id,Model model){

        userService.deleteUser(id);
        ModelAndView mav = new ModelAndView("redirect:/allUsers");
        System.out.println(id);
        List<User> allUsers = userService.getAllUser();
        model.addAttribute("users", allUsers);
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
}