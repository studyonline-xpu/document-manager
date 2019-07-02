package com.document.controller;

import com.document.pojo.Class;
import com.document.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping("/queryAllClass")
    public String queryAllClass(Model model) {
        List<Class> allClass = classService.queryAllClass();

        return "";
    }
}
