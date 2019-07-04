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
    /**
     * 插入文档类别
     * @param clazz 类别实体
     * @return
     */
    @Override
    public boolean insertClass(Class clazz) {
        int insert = classMapper.insert(clazz);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    /**
     * 更新文档类别
     * @param clazz 文档类别实体
     * @return
     */
    @Override
    public boolean updateClass(Class clazz) {
        int i = classMapper.updateByPrimaryKeySelective(clazz);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
