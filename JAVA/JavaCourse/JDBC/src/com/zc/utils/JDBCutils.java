/*
 *
 *
 */
package com.zc.utils;/*
 *@Author:
 *@CreateTime:2020-05-16-06
 *@description:将 驱动注册 数据库连接 和 关闭资源操作封装在
 一个专门的工具类中
 减少不必要的操作
 */

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCutils {
    //静态代码块只能调用静态变量
    private static String driver;
    private static String url;
    private static  String user;
    private  static String password;
    //驱动封装 应该放在静态代码中中 自动加载 且只执行一次
    static{
        //1获取properties类 读取Java的配置文件
        Properties pro=new Properties();
       //方法 通过 类加载器 获取 src  路径下的配置文件
       /* ClassLoader classLoader=JDBCutils.class.getClassLoader();
        URL res=classLoader.getResource("jdbc.properties");//获取文件的资源
        String path =res.getPath();*/
        //2加载配置文件
        try {
//            pro.load(new FileReader(path));//文件的读取
            pro.load(JDBCutils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3数据的获取 和 赋值
         url = pro.getProperty("url");
         user = pro.getProperty("user");
        password = pro.getProperty("password");
        //4 驱动注册
        driver=pro.getProperty("driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //封装数据库连接
    public static Connection getConnection(){
        Connection con=null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
    //封装 资源关闭
    public static void close(ResultSet res,Statement stat,Connection con){
        if (res != null) {
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
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
