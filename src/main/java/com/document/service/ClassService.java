package com.document.service;

import com.document.pojo.Class;

import java.util.List;

/**
 * 文档类别服务
 */
public interface ClassService {

    /**
     * 查询所有类别
     * @return
     */
    public List<Class> queryAllClass();

    /**
     * 插入文档类别
     * @param clazz 类别实体
     * @return
     */
    public boolean insertClass(Class clazz);
}
