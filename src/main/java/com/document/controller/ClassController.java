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

    /**
     * 插入文档类别
     * @param clazz 文档类别实体
     * @param result 存储返回的消息
     * @return
     */
    @RequestMapping("/insertClass")
    public String insertClass(Class clazz, Map result) {
        boolean b = classService.insertClass(clazz);
        if (b) {
            result.put("msg", "插入文档类别成功");
        } else {
            result.put("msg", "插入文档类别失败");
        }
        List<Class> classList = classService.queryAllClass();
        SystemResult systemResult;
        if(classList != null){
            systemResult =  SystemResult.build(200, "类别获取成功");
            systemResult.setData(classList);
        }else {
            systemResult = SystemResult.build(400, "类别获取失败");
        }
        result.put("classResult",classList);
        return "backstage/providerList";
    }

    /**
     * 更新文档类别
     * @param clazz 文档类别实体
     * @param result 存储返回的消息
     * @return
     */
    @RequestMapping("/updateClass")
    public String updateClass(Class clazz, Map result) {
        boolean b = classService.updateClass(clazz);
        List<Class> classList = classService.queryAllClass();
        if (b) {
            result.put("msg", "更新文档类别成功");
            result.put("classResult", classList);
        } else {
            result.put("msg","更新文档类别失败");
        }
        return "backstage/providerList";
    }

    /**
     * 删除文档类别
     * @param classId 文档类别的id
     * @param result 存储返回的消息
     * @return
     */
    @RequestMapping("/deleteClass")
    public String deleteClass(String classId, Map result) {
        boolean b = classService.deleteClass(classId);
        if (b) {
            result.put("msg", "删除文档类别成功");
        } else {
            result.put("msg", "删除文档类别失败");
        }
        return "";
    }
}
