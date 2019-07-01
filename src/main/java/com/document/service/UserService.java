package com.document.service;

import com.document.pojo.User;

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
}
