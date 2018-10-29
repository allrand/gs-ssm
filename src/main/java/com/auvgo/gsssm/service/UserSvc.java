package com.auvgo.gsssm.service;

import com.auvgo.gsssm.dao.mapper.UserMapper;
import com.auvgo.gsssm.entity.User;
import com.auvgo.gsssm.entity.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSvc {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        List<User> users = userMapper.selectByExample(null);
        logger.info("user list length: {}", users.size());
        if (users.size() > 0){
            return users;
        }else {
            return null;
        }
    }

    public User getUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getUser(User user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (user != null && user.getId() != null) {
            criteria.andIdEqualTo(user.getId());
        }
        return userMapper.selectByExample(example);
    }
}
