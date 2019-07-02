package com.document.service.impl;

import com.document.mapper.UserMapper;
import com.document.pojo.User;
import com.document.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LM_Code
 * @create 2019-07-01-15:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String userId, String password) {
        return userMapper.selectLogin(userId, password);
    }

    @Override
    public boolean register(User user) {
        int insert = userMapper.insert(user);
        if (insert > 0) {
            return true;
        }
        return false;
    }
}
