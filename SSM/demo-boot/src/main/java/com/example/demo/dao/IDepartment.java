package com.example.demo.dao;

import com.example.demo.entities.Department;

import java.util.Collection;

public interface IDepartment {

    /**
     * 获取所有部门
     * @return
     */
    public Collection<Department> getDepartments();

    /**
     * 查询某个部门
     */
    public Department getDepartment(Integer id);
}
