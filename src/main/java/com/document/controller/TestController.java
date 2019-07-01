package com.document.controller;

import com.document.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试使用的controller，查询当前时间
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;//注入服务
    @RequestMapping("/login")
    public String queryNow() throws IOException {
        //调用服务的方法
        return "login";
    }
}