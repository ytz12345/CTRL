package com.bupt.ctrl.service;

import com.bupt.ctrl.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void register(User user);

    User checkLogin(String userName, String password);

    User checkLogin_admin(String userName, String password);

    User getUserByID(Integer uid);

    public List<User>  getAllUser();

    public Map<String, Object> saveUser(User record);
}