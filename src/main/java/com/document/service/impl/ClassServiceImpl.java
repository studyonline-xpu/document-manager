package com.document.service.impl;

import com.document.mapper.ClassMapper;
import com.document.pojo.Class;
import com.document.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文档类别服务的实现
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    /**
     * 查询所有类别
     * @return
     */
    @Override
    public List<Class> queryAllClass() {
        List<Class> allFatherClass = classMapper.selectAllFatherClass();
        List<Class> allChildClass = null;
        for (Class fatherClass : allFatherClass) {
            allChildClass = classMapper.selectAllClass(fatherClass.getClassId());
            fatherClass.setChildClass(allChildClass);
        }
        return allFatherClass;
    }
}
