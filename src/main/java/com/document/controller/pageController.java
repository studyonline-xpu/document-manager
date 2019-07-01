package com.document.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

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
    //
    @RequestMapping("/index")
    public String login1() {
        return "login";
    }
    @RequestMapping("/login")
    public String login2() {
        return "login";
    }
}
