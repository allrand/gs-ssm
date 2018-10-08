package com.auvgo.gsssm.dao.mapper;

import com.auvgo.gsssm.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath*:spring-servlet.xml"})
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Ignore
    @Test
    public void deleteByExample() {
    }

    @Ignore
    @Test
    public void deleteByPrimaryKey() {
    }

//    @Ignore
    @Test
    public void insert() {
        User user = new User();
//        user.setId(2);
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(1991,1,12);
        Calendar calendar = new GregorianCalendar(1990,0,31);

        Date date = calendar.getTime();
        System.out.println(date);
        user.setBirthday(date);
        user.setSex("1");
        user.setUsername("水电费1990");
        user.setAddress("abc中文地址123");
        userMapper.insertSelective(user);
//        userMapper.insert(user);
    }

    @Test
    public void selectByExample() {
        List<User> users = userMapper.selectByExample(null);
        assertEquals(10, users.size());
    }

    @Ignore
    @Test
    public void updateByExample() {

    }
}