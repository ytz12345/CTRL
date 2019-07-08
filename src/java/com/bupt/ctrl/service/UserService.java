package com.bupt.ctrl.service;

import com.bupt.ctrl.model.User;

import java.util.Map;

public interface UserService {
    //用户注册
    void register(User user);

    //登录验证
    User checkLogin(String userName, String password);

    //根据id查找用户
    User getUserByID(Integer uid);
}