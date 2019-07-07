package com.bupt.ctrl.service;

import com.bupt.ctrl.model.User;

import java.util.Map;

public interface UserService {

    //注册
    void register(User user);

    //登录
    User checkLogin(String userName, String password);

    User getUserByID(Integer uid);

    public Map<String, Object> saveUser(User record);
}