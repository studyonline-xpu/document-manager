package com.document.service;

import com.document.pojo.Manager;

/**
 * @autnor RenJing
 * @date 2019/7/3 8:43
 */
public interface ManagerService {

    /**
     * 登录方法
     * @param managerId 管理员id
     * @param password 管理员密码
     * @return
     */
    Manager selectLogin(String managerId, String password);
}
