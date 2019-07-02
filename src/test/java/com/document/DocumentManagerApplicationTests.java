package com.document;

import com.document.pojo.Class;
import com.document.pojo.User;
import com.document.service.ClassService;
import com.document.service.UserService;
import com.document.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentManagerApplicationTests {
    @Autowired
    public UserService userService;

    @Test
    public void testRegister(){
        User user = new User();
        user.setUserName("hhh");
        boolean register = userService.register(user);
        System.out.println(register);
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
