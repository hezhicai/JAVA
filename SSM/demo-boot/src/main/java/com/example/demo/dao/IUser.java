package com.example.demo.dao;

import com.example.demo.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUser {

    /**
     * 查询所有用户
     */
    public User findUser(@Param("username") String username,@Param("password") String password);
}
