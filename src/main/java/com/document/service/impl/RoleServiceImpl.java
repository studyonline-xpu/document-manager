package com.document.service.impl;

import com.document.mapper.RoleMapper;
import com.document.pojo.Role;
import com.document.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autnor RenJing
 * @date 2019/7/4 10:00
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }
}
