package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.impl.UserDaoImpl;
import com.bupt.ctrl.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements com.bupt.ctrl.service.UserService {

    //依赖Dao
    @Resource
    private UserDaoImpl userDaoImpl;
    // 注入事务管理
    @Transactional(rollbackFor={Exception.class, RuntimeException.class})
    public User getUser(int uid) {
        return userDaoImpl.getUserByID(uid);
    }

    @Transactional(rollbackFor={Exception.class, RuntimeException.class})
    public void saveUser(User user) {
        userDaoImpl.saveUser(user);
    }
}

