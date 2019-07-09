package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.common.CommonEnum;
import com.bupt.ctrl.dao.UserHasChapterMapper;
import com.bupt.ctrl.dao.UserMapper;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.model.UserExample;
import com.bupt.ctrl.service.CommentService;
import com.bupt.ctrl.service.UserHasChapterService;
import com.bupt.ctrl.service.UserHasCourseService;
import com.bupt.ctrl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByID(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    //注册
    @Override
    public void register(User user){
        userMapper.insert(user);
    }

    //登录
    @Override
    public User checkLogin(String userName, String password){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> user = userMapper.selectByExample(userExample);

        if(user.size() != 0 && user.get(0).getUserPassword().equals(password)){
            return user.get(0);
        }

        return null;
    }

    @Override
    public User checkLoginAdmin(String userName, String password){
        User user = checkLogin(userName, password);

        if(user != null && user.getUserIdentity().equals(0)){
            return user;
        }

        return null;
    }

    @Override
    public List<User> getAllUser() {
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);

    }

    @Override
    public void deleteUser(Integer uid) {
        System.out.println("try delete");
        userMapper.deleteByPrimaryKey(uid);
        System.out.println("sus");
    }

    public List<User> getTeachers(){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdentityEqualTo(2);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User getTeacherByName(String userName){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        User user = new User();
        if(userList.size() != 0){
            for(int i = 0; i <= userList.size(); i ++)
                if(userList.get(i).getUserIdentity() == 2){
                    user = userList.get(i);
                    return user;
                }
        }
        return null;
    }

    @Override
    public int updateUserPassword(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andUserIdEqualTo(user.getUserId());
        userMapper.updateByExampleSelective(user,userExample);
        return 1;
    }
}

