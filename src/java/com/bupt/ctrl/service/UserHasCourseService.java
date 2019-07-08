package com.bupt.ctrl.service;

import com.bupt.ctrl.model.UserHasCourse;

import java.util.Map;

import java.util.List;

public interface UserHasCourseService {

    public List<UserHasCourse> getCourseById(Integer user_id);
}