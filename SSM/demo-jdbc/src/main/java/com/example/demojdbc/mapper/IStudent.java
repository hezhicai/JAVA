package com.example.demojdbc.mapper;

import com.example.demojdbc.bean.Account;
import com.example.demojdbc.bean.Student;

public interface IStudent {
    /**
     * 插入
     * @param student
     * @return
     */
    public int insert(Student student);
}
