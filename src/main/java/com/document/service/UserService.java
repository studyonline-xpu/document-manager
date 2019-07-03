package com.document.service;

import com.document.pojo.User;

import java.util.List;

/**
 * @author LM_Code
 * @create 2019-07-01-15:52
 */
public interface UserService {

    /**
     * 登陆方法
     * @param userId 用户id
     * @param password 密码
     * @return
     */
    public User login(String userId, String password);

    /**
     * 注册方法
     * @param user 用户实体
     * @return
     */
    public boolean register(User user);

    /**
     * 后台：查询所有用户
     * @return
     */
    public List<User> selectAllUser();
}
