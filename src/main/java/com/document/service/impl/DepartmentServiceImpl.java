package com.document.service.impl;

import com.document.mapper.DepartmentMapper;
import com.document.pojo.Department;
import com.document.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autnor RenJing
 * @date 2019/7/4 10:29
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }
}
