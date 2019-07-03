package com.bupt.ctrl.dao;

import com.bupt.ctrl.model.User_has_course;
import com.bupt.ctrl.model.User_has_courseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User_has_courseMapper {
    long countByExample(User_has_courseExample example);

    int deleteByExample(User_has_courseExample example);

    int insert(User_has_course record);

    int insertSelective(User_has_course record);

    List<User_has_course> selectByExample(User_has_courseExample example);

    int updateByExampleSelective(@Param("record") User_has_course record, @Param("example") User_has_courseExample example);

    int updateByExample(@Param("record") User_has_course record, @Param("example") User_has_courseExample example);
}