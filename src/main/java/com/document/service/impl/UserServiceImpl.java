package com.document.service.impl;

import com.document.mapper.UserMapper;
import com.document.pojo.User;
import com.document.service.UserService;
import com.document.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LM_Code
 * @create 2019-07-01-15:57
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 登录方法
     */
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String userId, String password) {
        return userMapper.selectLogin(userId, password);
    }

    /**
     * 注册方法
     * @param user 用户实体
     * @return
     */
    @Override
    public boolean register(User user) {
        String id = IdUtil.next();//生成唯一的id
        user.setUserId(id);
        int insert = userMapper.insert(user);
        if (insert > 0) {
            System.out.println(user);
            return true;
        }
        return false;
    }
}
