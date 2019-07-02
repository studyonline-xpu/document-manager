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

import java.util.Map;

/**
 * @author LM_Code
 * @create 2019-07-01-15:49
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;//注入

    /**
     * 登陆方法：post方法请求
     * @param userId 用户id
     * @param password 用户密码
     * @param model 存入登陆失败提示
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String userId, String password, Model model){
        User user = userService.login(userId, password);
        SystemResult result;
        if(user != null){
            return "redirect:/class/queryAllClass";
        }
        else{
            model.addAttribute("msg", "账号或密码错误!");
            return "login";
        }
    }

    /**
     * 注册方法：post方法请求
     * @param user 用户实体
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public SystemResult register(User user, Map<String,Object> map) {
        boolean register = userService.register(user);
        SystemResult result = new SystemResult(200,"OK",null);
        if (register) {
            map.put("msg", "注册成功，请您登录！");
        }
        return result;
    }
}
