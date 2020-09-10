/*
 *
 *
 */
package com.zc.jdbc_01;/*
 *@Author:
 *@CreateTime:2020-05-15-07
 *@description:使用prepareStatement预编译 sql语句 防止sql注入：用户输入的内容和sql语句拼接 影响了查询结果
 */
import com.zc.utils.JDBCutils;
import java.sql.*;
import java.util.Scanner;
public class loginDemo02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String user= sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        if(new loginDemo02().login(user,password)){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
    }
    //通过输入 用户名 和密码 判断 用户 是否 登陆 成功
    public boolean login(String userName,String password){
        Connection con=null;
        PreparedStatement stat=null;
        ResultSet res=null;
        if(userName==null||password==null){
            return false;
        }
        //使用工具类 连接数据库
        con = JDBCutils.getConnection();
        //sql
        String sql="select * from login where userName=? and password=? ";
        //preparestatement
        try {

         stat = con.prepareStatement(sql);//先传如sql语句
             stat.setString(1,userName);//给具体 用户名赋值
             stat.setString(2,password);
             res = stat.executeQuery();
            return res.next();//如果 下一行 則返回 true
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutils.close(res, stat, con);
        }
        return false;
    }
}
