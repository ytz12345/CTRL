package com.bupt.ctrl.dao;

import com.bupt.ctrl.model.User;

public interface UserDao {

    User getUserByID(int user_id);

    void saveUser(User user);

    /*User findUserByPwdAndID(User user);

    void deleteByID(int user_id);

    void delete1(int user_id);

    void delete2(int user_id);

    void delete3(int user_id);

    boolean occupy(User user);*/
}
