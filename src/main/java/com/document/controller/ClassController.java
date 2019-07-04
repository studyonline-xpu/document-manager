package com.document.controller;

import com.document.pojo.Class;
import com.document.pojo.SystemResult;
import com.document.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author LM_Code
 * @create 2019-07-02-8:50
 */
@RequestMapping("/class")
@Controller
public class ClassController {
    @Autowired
    ClassService classService;

    /**
     * 获取所有类别
     * @return
     */
//    @ResponseBody
    @RequestMapping("/queryAllClass")
    public String queryAllClass(Integer flag,Map<String,Object> map){
        List<Class> classList = classService.queryAllClass();
        SystemResult systemResult;
        if(classList != null){
            systemResult =  SystemResult.build(200, "类别获取成功");
            systemResult.setData(classList);
        }else {
            systemResult = SystemResult.build(400, "类别获取失败");
        }
        map.put("classResult",classList);
        if (flag == 1) {
            return "backstage/providerList";
        } else {
            return "index/index";
        }
    }
}
