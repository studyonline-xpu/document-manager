package com.document.service;

import com.document.pojo.Role;

import java.util.List;

/**
 * @autnor RenJing
 * @date 2019/7/4 9:59
 */
public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> selectAllRole();
}
