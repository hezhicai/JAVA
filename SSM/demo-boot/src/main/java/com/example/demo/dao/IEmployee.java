package com.example.demo.dao;

import com.example.demo.entities.Employee;

import java.util.Collection;
import java.util.HashMap;

public interface IEmployee {
    /**
     * 增
     * @param hashMap
     */
    public void save(Employee emp);

    /**
     * 展示
     * @return
     */
    public Collection<Employee> getAll();

    /**
     * 查
     * @param id
     * @return
     */
    public Employee get(Integer id);
    /**
     * 修改员工信息
     *
     */
    public void update(Employee emp);

    /**
     * 删
     * @param id
     */
    public void delete(Integer id);
}
