package com.bupt.ctrl.service.impl;
import com.bupt.ctrl.dao.UserHasChapterMapper;
import com.bupt.ctrl.service.UserHasChapterService;

public class UserHasChapterServiceImpl implements UserHasChapterService {
    UserHasChapterMapper userHasChapterMapper;
    //根据userid删除UHC表的内容
    //在管理员删除用户表前需要先删除外键表
    public void deleteUserHasChap(Integer uid) {
        userHasChapterMapper.deleteUserHasChap(uid);
    }
}
