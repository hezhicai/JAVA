/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.jdbc_01;/*
 *@Author:
 *@CreateTime:2020-05-12-28
 *@description:执行两条sql
 */

import java.sql.*;

public class insertDemo {
    public static void main(String[] args) {
        Connection con = null;
       PreparedStatement Stat = null;
       PreparedStatement Stat2=null;
        try {
               Class.forName("com.mysql.jdbc.Driver");//注册驱动
                //创建数据库连接对象
                con = DriverManager.getConnection("jdbc:mysql:///test", "root", "123");
                con.setAutoCommit(false);//在执行sql语句前开启事务
                //编写sql执行语句
                String sql = "insert into student values(2005,'小智','男')";
                String  sql2=" insert into student values(2006,'小王','女')";
                //获取执行sql语句的对象
                Stat=con.prepareStatement(sql);
                Stat2=con.prepareStatement(sql2);
                //记录受影响的行数
                int count = Stat.executeUpdate();
                int s=2/0;//制造异常---->结果 是 第一条执行成功；如果处理事务的话 可以取消第一条语句的操作
                int count2 =Stat2.executeUpdate();
                con.commit();//sql语句执行完提交事务
                //判断sql语句是否执行成功
                if (count > 0) {
                    System.out.println(count);
                    System.out.println("插入成功");
                } else {
                    System.out.println("插入失败");
                }
            } catch (Exception throwables) {
            if(con!=null){
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            throwables.printStackTrace();
            }  finally {//不管上面有没有问题都要释放资源
            if (Stat != null) {
                try {
                    Stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (con != null) {

                try {

                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
