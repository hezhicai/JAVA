package com.example.demojdbc.controller;
import com.example.demojdbc.bean.Account;
import com.example.demojdbc.mapper.IAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@Controller
public class AccountController {
    //替代Autowired
    @Resource
    IAccount iAccount;
    @ResponseBody
    @GetMapping("/list")
    public List<Account> list(){

        return  iAccount.list();
    }
    @ResponseBody
    @GetMapping("/insert")
    public Account insert(Account account){
       iAccount.insert(account);
        //返回参数 json
        return account;
    }
    @ResponseBody
    @GetMapping("/update/{id}")
    public Account update(@PathVariable("id") int id){
        Account account=new Account();
        account.setId(id);
        account.setUserName("ts");
        account.setBalance(789);
        iAccount.update(account);
        return account;
    }
}
