package com.document.service;

import com.document.pojo.Department;

import java.util.List;

/**
 * @autnor RenJing
 * @date 2019/7/4 10:28
 */
public interface DepartmentService {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> selectAllDepartment();
}
