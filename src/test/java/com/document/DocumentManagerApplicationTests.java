package com.document;

import com.document.pojo.Class;
import com.document.service.ClassService;
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
    public ClassService classService;
    @Test
    public void contextLoads() {
        List<Class> allClass = classService.queryAllClass();
        for (Class aClass : allClass) {
            System.out.println(aClass);
        }
    }

}
