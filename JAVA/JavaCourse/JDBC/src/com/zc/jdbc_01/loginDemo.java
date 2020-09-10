/*
 *
 *


/*
*@CreateTime:2020-05-16-48
 *@description:使用封装好的工具类 登陆案例 --判定用户 是否 登陆 成功
 */
package com.zc.jdbc_01;


import com.zc.utils.JDBCutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class loginDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String user= sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        if(new loginDemo().login(user,password)){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
    }
    //通过输入 用户名 和密码 判断 用户 是否 登陆 成功
    public boolean login(String userName,String password){
        Connection con=null;
        Statement stat=null;
        ResultSet res=null;
        if(userName==null||password==null){
            return false;
        }
        //使用工具类 连接数据库
        con = JDBCutils.getConnection();
        //sql
        String sql="select * from login where userName='"+userName+"' and password='"+password+"' ";
        //statement
        try {
            stat = con.createStatement();
            res = stat.executeQuery(sql);
            return res.next();//如果 下一行 則返回 true
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutils.close(res, stat, con);
        }
        return false;
    }
}
