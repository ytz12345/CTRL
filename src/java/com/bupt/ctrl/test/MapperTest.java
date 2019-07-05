package com.bupt.ctrl.test;

import com.bupt.ctrl.dao.UserMapper;
import com.bupt.ctrl.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 测试dao的工作
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class MapperTest {

    /*
     * 测试UserMapper
     */
    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        /*//创建IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-dao.xml");
        //容器中获取mapper
        UserMapper bean = ioc.getBean(UserMapper.class);*/

        //System.out.println(userMapper);
        //userMapper.insertSelective(new User(null, "mapperTest"));
    }

}
