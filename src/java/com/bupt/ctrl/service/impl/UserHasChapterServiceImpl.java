package com.bupt.ctrl.service.impl;
import com.bupt.ctrl.dao.UserHasChapterMapper;
import com.bupt.ctrl.model.UserHasChapterExample;
import com.bupt.ctrl.service.UserHasChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHasChapterServiceImpl implements UserHasChapterService {
    @Autowired
    UserHasChapterMapper userHasChapterMapper;
    //根据userid删除UHC表的内容
    //在管理员删除用户表前需要先删除外键表
    public void deleteUserHasChap(Integer uid) {
        System.out.println("try delete");
        UserHasChapterExample userHasChapterExample = new UserHasChapterExample();
        UserHasChapterExample.Criteria criteria = userHasChapterExample.createCriteria();
        criteria.andUserUserIdEqualTo(uid);
        userHasChapterMapper.deleteByExample(userHasChapterExample);
        System.out.println("sd");
    }
}
