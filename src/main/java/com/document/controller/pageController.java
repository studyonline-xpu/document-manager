package com.document.controller;

import com.document.pojo.Department;
import com.document.pojo.Role;
import com.document.pojo.User;
import com.document.service.DepartmentService;
import com.document.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author LM_Code
 * @create 2019-07-01-16:27
 */
@Controller
public class pageController {

    //默认8080端口直接跳到登陆页面
    @RequestMapping("/")
    public String login() {
        return "login";
    }
    //登录2
    @RequestMapping("/index")
    public String login1() {
        return "login";
    }
    //登录3
    @RequestMapping("/login")
    public String login2() {
        return "login";
    }

    @RequestMapping("/table")
    public String table(){
        return "index/table-basic";
    }

    @RequestMapping("/index/right")
    public String right(){
        return "index/right";
    }

    //添加的注入
    @Autowired
    RoleService roleService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 修改用户的角色以及部门名称
     * @param result
     * @return
     */
    @RequestMapping("/user/update")
    public String goUpdateUserRoleAndDepartment(User user, Map result) {
        List<Role> roles = roleService.selectAllRole();
        List<Department> departments = departmentService.selectAllDepartment();
        result.put("roles",roles);
        result.put("user", user);
        result.put("departments",departments);
        return "backstage/userUpdate";
    }
}
