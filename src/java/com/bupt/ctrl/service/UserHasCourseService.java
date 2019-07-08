package com.bupt.ctrl.service;

import com.bupt.ctrl.model.UserHasCourse;

import java.util.Map;

import java.util.List;

//根据传入的用户ID查询他的UserHasCourse列表
public interface UserHasCourseService {

    public List<UserHasCourse> getCourseById(Integer user_id);
}