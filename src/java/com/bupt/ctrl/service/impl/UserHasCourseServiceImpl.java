package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.UserHasCourseMapper;
import com.bupt.ctrl.model.UserHasCourse;
import com.bupt.ctrl.model.UserHasCourseExample;
import com.bupt.ctrl.service.UserHasCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHasCourseServiceImpl implements UserHasCourseService{

    @Autowired
    UserHasCourseMapper userHasCourseMapper;

    //根据传入的用户ID查询他的UserHasCourse列表
    public List<UserHasCourse> getCourseById(Integer user_id){
        UserHasCourseExample userHasCourseExample = new UserHasCourseExample();
        UserHasCourseExample.Criteria criteria = userHasCourseExample.createCriteria();
        criteria.andUserUserIdEqualTo(user_id);
        return userHasCourseMapper.selectByExample(userHasCourseExample);
    }

}
