package com.document.controller;

import com.document.pojo.*;
import com.document.pojo.Class;
import com.document.service.ClassService;
import com.document.service.DepartmentService;
import com.document.service.DocumentService;
import com.document.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    //登录2
    @RequestMapping("/index")
    public String login1() {
        return "login";
    }
    //登录3
    @RequestMapping("/login")
    public String login2() {
        return "login";
    }

    @RequestMapping("/table")
    public String table(){
        return "index/table-basic";
    }

    @RequestMapping("/index/right")
    public String right(){
        return "index/right";
    }

    @RequestMapping("/documentForm")
    public String form(Map map) {
        List<Class> classes = classService.queryAllClass();
        map.put("classResult",classes);
        return "index/form-basic";
    }


    //添加的注入
    @Autowired
    RoleService roleService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    ClassService classService;

    /**
     * 修改用户的角色以及部门名称
     * @param result
     * @return
     */
    @RequestMapping("/user/update")
    public String goUpdateUserRoleAndDepartment(User user, Map result) {
        List<Role> roles = roleService.selectAllRole();
        List<Department> departments = departmentService.selectAllDepartment();
        result.put("roles",roles);
        result.put("user", user);
        result.put("departments",departments);
        return "backstage/userUpdate";
    }

    /**
     * 增加文档类别
     * @return
     */
    @RequestMapping("/class/providerAdd")
    public String addDocumentClass(Map result){
        List<Class> classes = classService.queryAllClass();
        result.put("classes", classes);
        System.out.println(123);
        return "backstage/providerAdd";
    }

    /**
     * 修改文档类别
     * @param clazz
     * @param result
     * @return
     */
    @RequestMapping("/updateClassId")
    public String goClassIdUpdate(Class clazz, Map result) {
        result.put("clazz", clazz);
        return "backstage/classIdUpdate";
    }

    /**
     * 查看单个文档内容
     */
    @Autowired
    DocumentService documentService;

    @RequestMapping("/viewOneDocument")
    public String goDocumentView(Document document, Map result) {
        List<Document> documentList = documentService.queryByLikeDocumentName(document.getDocumentName());
        result.put("documentList", documentList);
        return "backstage/documentView";
    }
}
