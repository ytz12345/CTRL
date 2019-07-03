package com.bupt.ctrl.service;

import com.bupt.ctrl.model.User;

public interface IUserService {

    User getUser(int uid);

    void saveUser(User user);
}