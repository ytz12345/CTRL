package com.bupt.ctrl.service;

import com.bupt.ctrl.dao.UserDao;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserService implements IUserService {

    //依赖Dao
    @Resource
    private UserDao userDao;
    // 注入事务管理
    @Transactional(rollbackFor={Exception.class, RuntimeException.class})
    public User getUser(int uid) {
        return userDao.getUserByID(uid);
    }

    @Transactional(rollbackFor={Exception.class, RuntimeException.class})
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}

