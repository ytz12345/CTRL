package com.bupt.ctrl.service.impl;
import com.bupt.ctrl.dao.UserHasChapterMapper;
import com.bupt.ctrl.model.UserHasChapter;
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

    public UserHasChapter getHasLearned(Integer uid, Integer chapterId){
        UserHasChapterExample userHasChapterExample = new UserHasChapterExample();
        UserHasChapterExample.Criteria criteria = userHasChapterExample.createCriteria();
        criteria.andUserUserIdEqualTo(uid);
        criteria.andChapterChapterIdEqualTo(chapterId);
        if(userHasChapterMapper.selectByExample(userHasChapterExample).size() != 0){
            return userHasChapterMapper.selectByExample(userHasChapterExample).get(0);
        }
        return null;
    }

    public void setHasLearned(UserHasChapter userHasChapter){
        UserHasChapterExample userHasChapterExample = new UserHasChapterExample();
        UserHasChapterExample.Criteria criteria = userHasChapterExample.createCriteria();
        criteria.andUserUserIdEqualTo(userHasChapter.getUserUserId());
        criteria.andChapterChapterIdEqualTo(userHasChapter.getChapterChapterId());
        userHasChapterMapper.updateByExampleSelective(userHasChapter,userHasChapterExample);
    }

    public void insertHasLearned(UserHasChapter userHasChapter){
        userHasChapterMapper.insert(userHasChapter);
    }
}
