package com.bupt.ctrl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{

    //定义存放到值栈中的对象
    private User user;

    //依赖service
    @Resource
    private UserServiceImpl userServiceImpl;

    //实现要存放到值栈中对象的get方法
    public User getUser() {
        return user;
    }

    public String m1(){
        user =  userServiceImpl.getUser(1);

        return SUCCESS;
    }

    public String saveUser(){
        User user = new User();
        userServiceImpl.saveUser(user);

        return SUCCESS;
    }
}
