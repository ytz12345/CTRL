package com.bupt.ctrl.service;

public interface UserHasChapterService {


    //根据userid删除UHC表的内容
    //在管理员删除用户表前需要先删除外键表
    void deleteUserHasChap(Integer uid);
}

