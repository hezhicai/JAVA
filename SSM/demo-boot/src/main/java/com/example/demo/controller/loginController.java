package com.example.demo.controller;
import com.example.demo.dao.IUser;
import com.example.demo.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class loginController {

    @Resource
    IUser iUser;

    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password, HashMap<String,Object> hashMap, HttpSession session){


        if(iUser.findUser(username,password)!=null){
            session.setAttribute("loginUser",username);//保存登录的用户
            return "redirect:/main.html";//登录成功后，重定向到main.HTML页面  避免重复提交表单
        }else{
            hashMap.put("msg","登录失败");
            return "login";//进入login页面
        }

    }
}
