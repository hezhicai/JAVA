/*
 * 版权所有(C) ,何智才,2020;
 */
package com.zc.jdbc_01;/*
 *@CreateTime:2020-05-13-48
 */
import com.zc.table.student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class selectDemo {
    public static void main(String[] args) {
       selectDemo selectDemo=new selectDemo();
        List<student> liststudent = selectDemo.liststudent();
        System.out.println(liststudent);
    }
    //遍历封装好的学生对象
    public List<student> liststudent(){
        Connection con=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<student> list=null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            con= DriverManager.getConnection("jdbc:mysql:///test", "root", "123");
            //sql语句
            String sql="select * from student";
            //获取执行对象
             statement = con.createStatement();
            //执行sql
             resultSet = statement.executeQuery(sql);
             student stu;
              list=new ArrayList<student>();
             while(resultSet.next()){
                 int sno = resultSet.getInt("sno");
                 String name = resultSet.getString("name");
                 String sex = resultSet.getString("sex");
                 stu=new student();//新建一个对象
                 stu.setSno(sno);
                 stu.setName(name);
                 stu.setSex(sex);
                 list.add(stu);
                 System.out.println();
             }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }
}
