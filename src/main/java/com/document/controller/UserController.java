package com.document.controller;

import com.document.pojo.Department;
import com.document.pojo.Role;
import com.document.pojo.SystemResult;
import com.document.pojo.User;
import com.document.service.DepartmentService;
import com.document.service.RoleService;
import com.document.service.UserService;
import com.document.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
    public String login(String userId, String password, Model model, HttpSession httpSession){
        User user = userService.login(userId, password);
        SystemResult result;
        if(user != null){
            httpSession.setAttribute("user", user);
            return "redirect:/class/queryAllClass?flag=0";
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

    /**
     * 查询所有用户
     * @param map
     * @return
     */
    @RequestMapping("/selectAllUser")
    public String selectAllUser(Map map) {
        List<User> userList = userService.selectAllUser();
        SystemResult systemResult;
        if (userList != null) {
            systemResult = SystemResult.build(200, "查询所有用户成功");
            systemResult.setData(userList);
        } else {
            systemResult = SystemResult.build(400, "查询所有用户失败");
        }
        map.put("systemResult", systemResult);
        map.put("userList", userList);
        return "backstage/userList";
    }

    /**
     * 根据id删除用户
     * @param userId 用户id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUserByUserId")
    public String deleteUserByUserId(String userId){
        Map result = new HashMap();
        if(userService.deleteUserByUserId(userId)){
            result.put("msg", "删除成功");
        }else {
            result.put("msg", "删除失败");
        }
        return JsonUtils.objectToJson(result);
    }

    @RequestMapping("/updateUserRoleAndDepartment")
    public String updateUserRoleAndDepartment(User user, Map result) {
        boolean b = userService.updateUserRoleAndDepartment(user);
        List<User> users = userService.selectAllUser();
        result.put("userList", users);
        if (b) {
            result.put("msg","更新成功");
        }else{
            result.put("msg","更新失败");
        }
        return "backstage/userList";
    }
}
