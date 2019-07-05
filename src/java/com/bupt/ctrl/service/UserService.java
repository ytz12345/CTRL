package com.bupt.ctrl.service;

import com.bupt.ctrl.model.User;

import java.util.Map;

public interface UserService {

    User getUserByID(Integer uid);

    public Map<String, Object> saveUser(User record);
}