package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.common.CommonEnum;
import com.bupt.ctrl.dao.UserMapper;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.model.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements com.bupt.ctrl.service.UserService {
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
        User user = userMapper.findByName(userName);

        if(user != null && user.getUserPassword().equals(password)){
            return user;
        }

        return null;
    }

    @Override
    public Map<String, Object> saveUser(User record) {
        Map<String,Object> map=new HashMap<String,Object>();
        int num = userMapper.insertSelective(record);
        //失败
        if (num == 0) {
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg", CommonEnum.REQUEST_FAILED.getMsg());
            return map;
        }
        //成功
        map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
        map.put("resmsg",CommonEnum.REQUEST_SUCCESS.getMsg());
        UserExample suithouse = new UserExample();
        List<User> list = userMapper.selectByExample(suithouse);
        map.put("houseId",list.get(list.size()-1).getUserId());
        return map;
    }
}

