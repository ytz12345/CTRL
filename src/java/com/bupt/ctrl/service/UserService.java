package com.bupt.ctrl.service;

import com.bupt.ctrl.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //用户注册
    void register(User user);

    //登录验证
    User checkLogin(String userName, String password);

    //检验admin登录
    User checkLoginAdmin(String userName, String password);
    
    //获得所有用户
    public List<User>  getAllUser(); 
   
    //根据id查找用户
    User getUserByID(Integer uid);

    //根据新密码更新数据库中的用户密码
    int updateUserPassword(User user);
}