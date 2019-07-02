package com.document.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyConfig implements WebMvcConfigurer {
   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/index").setViewName("login");
       registry.addViewController("/").setViewName("login");
       registry.addViewController("/index.html").setViewName("login");
       registry.addViewController("/main.html").setViewName("index/index");
       registry.addViewController("/table-basic.html").setViewName("index/table-basic");
       registry.addViewController("/register").setViewName("register.html");
   }
}