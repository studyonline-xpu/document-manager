package com.document.controller;

import com.document.pojo.Role;
import com.document.pojo.SystemResult;
import com.document.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @autnor RenJing
 * @date 2019/7/4 10:02
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/selectAllRole")
    @ResponseBody
    public SystemResult selectAllRole(){
        List<Role> roleList = roleService.selectAllRole();
        SystemResult systemResult;
        if (roleList != null) {
            systemResult = SystemResult.build(200, "查询所有角色成功");
            systemResult.setData(roleList);
        } else {
            systemResult = SystemResult.build(400, "查询所有角色失败");
        }
        return systemResult;
    }
}
