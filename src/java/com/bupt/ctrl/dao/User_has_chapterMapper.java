package com.bupt.ctrl.dao;

import com.bupt.ctrl.model.User_has_chapter;
import com.bupt.ctrl.model.User_has_chapterExample;
import com.bupt.ctrl.model.User_has_chapterKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User_has_chapterMapper {
    long countByExample(User_has_chapterExample example);

    int deleteByExample(User_has_chapterExample example);

    int deleteByPrimaryKey(User_has_chapterKey key);

    int insert(User_has_chapter record);

    int insertSelective(User_has_chapter record);

    List<User_has_chapter> selectByExample(User_has_chapterExample example);

    User_has_chapter selectByPrimaryKey(User_has_chapterKey key);

    int updateByExampleSelective(@Param("record") User_has_chapter record, @Param("example") User_has_chapterExample example);

    int updateByExample(@Param("record") User_has_chapter record, @Param("example") User_has_chapterExample example);

    int updateByPrimaryKeySelective(User_has_chapter record);

    int updateByPrimaryKey(User_has_chapter record);
}