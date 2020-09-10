package com.example.demojdbc.mapper;

import com.example.demojdbc.bean.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IAccount {
    /**
     * 查
     */
    @Select("select * from account")
    public List<Account> list();
/**
 * 增
 */
@Insert("insert account(userName,balance) values(#{userName},#{balance})")
public int insert(Account account);
/**
 * 改
 */
@Update("update account set userName=#{userName},balance=#{balance} where id=#{id}")
public int update(Account account);

}
