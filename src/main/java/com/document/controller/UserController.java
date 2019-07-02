package com.document.controller;

import com.document.pojo.SystemResult;
import com.document.pojo.User;
import com.document.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String userId, String password, Model model){
        User user = userService.login(userId, password);
        SystemResult result;
        if(user != null){
            System.out.println(user);
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg", "账号或密码错误!");
            return "login";
        }
    }
}
