package com.document.controller;

import com.document.pojo.Manager;
import com.document.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @autnor RenJing
 * @date 2019/7/3 9:20
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    /**
     * 登录的方法
     * @param managerId 管理员id
     * @param password 管理员密码
     * @param map 存储登录失败的提示
     * @return
     */
    @RequestMapping("/login")
    public String login(String managerId, String password, Map map) {
        Manager manager = managerService.selectLogin(managerId, password);
        if (manager != null) {
            return "redirect:/backstage-index";
        }else{
            map.put("msg","用户名或密码错误");
            return "redirect:/manager-login";
        }
    }
}
