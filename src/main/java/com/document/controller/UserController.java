package com.document.controller;

import com.document.pojo.SystemResult;
import com.document.pojo.User;
import com.document.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LM_Code
 * @create 2019-07-01-15:49
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;//注入
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public SystemResult login(String userId, String password){
        User user = userService.login(userId, password);
        SystemResult result = SystemResult.ok(user);
        return result;
    }
}
