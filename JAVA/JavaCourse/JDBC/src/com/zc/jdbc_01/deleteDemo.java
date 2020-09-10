
package com.zc.jdbc_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteDemo {
        public static void main(String[] args) {
            Connection con = null;
            Statement Stat = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");//注册驱动
                //创建数据库连接对象
                con = DriverManager.getConnection("jdbc:mysql:///test", "root", "123");
                //编写sql执行语句
                String sql = "delete  from student where sno=2004 ";
                //获取执行sql语句的对象
                 Stat= con.createStatement();
                //记录受影响的行数
                int count = Stat.executeUpdate(sql);
                //判断sql语句是否执行成功
                if (count > 0) {
                    System.out.println(count);
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {//不管上面有没有问题都要释放资源
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
