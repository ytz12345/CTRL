package com.bupt.ctrl.service;

import com.bupt.ctrl.model.User;

public interface UserService {

    User getUser(int uid);

    void saveUser(User user);
}