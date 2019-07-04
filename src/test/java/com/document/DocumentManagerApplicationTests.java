package com.document;

import com.document.pojo.Class;
import com.document.pojo.Document;
import com.document.pojo.Role;
import com.document.pojo.User;
import com.document.service.ClassService;
import com.document.service.DocumentService;
import com.document.service.RoleService;
import com.document.service.UserService;
import com.document.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentManagerApplicationTests {
    @Autowired
    RoleService roleService;

    @Test
    public void testSelectAllRole() {
        List<Role> roles = roleService.selectAllRole();
        System.out.println(roles);
    }

    @Test
    public void testCreateTime() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(time);
    }

    @Autowired
    public DocumentService documentService;

    @Test
    public void testQueryByDocumentName() {
        List<Document> documentList = documentService.queryByLikeDocumentName("aa");
        System.out.println(documentList);
    }

    @Autowired
    public UserService userService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setUserName("hhh");
        boolean register = userService.register(user);
        System.out.println(register);
    }

    @Test
    public void testSelectAllUser() {
        List<User> users = userService.selectAllUser();
        System.out.println(users);
    }

    @Autowired
    public ClassService classService;

    @Test
    public void contextLoads() {
        List<Class> allClass = classService.queryAllClass();
        for (Class aClass : allClass) {
            System.out.println(aClass);
        }
    }

    @Test
    public void testIdUtil() {
        System.out.println(IdUtil.next());
        System.out.println(IdUtil.next());
        System.out.println(IdUtil.next());
        System.out.println(IdUtil.next());
    }

}
