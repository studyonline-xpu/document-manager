package com.document.service.impl;

import com.document.mapper.ManagerMapper;
import com.document.pojo.Manager;
import com.document.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @autnor RenJing
 * @date 2019/7/3 9:14
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 登录方法
     * @param managerId 管理员id
     * @param password 管理员密码
     * @return
     */
    @Override
    public Manager selectLogin(String managerId, String password) {
        return managerMapper.selectLogin(managerId, password);
    }
}
