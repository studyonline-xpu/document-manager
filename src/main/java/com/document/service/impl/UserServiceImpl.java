package com.document.service.impl;

import com.document.mapper.UserMapper;
import com.document.pojo.User;
import com.document.service.UserService;
import com.document.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        String id = IdUtil.next();//生成唯一的id
        user.setUserId(id);
        user.setCreateTime(time);
        int insert = userMapper.insert(user);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    /**
     * 后台：查询所有用户
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public boolean deleteUserByUserId(String userId) {
        return userMapper.deleteByPrimaryKey(userId) > 0;
    }
}
