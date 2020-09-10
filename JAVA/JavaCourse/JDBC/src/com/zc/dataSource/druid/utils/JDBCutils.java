/*
 *
 *
 */
package com.zc.dataSource.druid.utils;/*
 *@Author:
 *@CreateTime:2020-05-17-57
 *@description:数据库连接池  工具类：获取 数据库 连接对象 和 数据 库连接池 以及 关闭资源
 */
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JDBCutils {
   private static DataSource dataSource=null;//静态变量 需要 静态代码块来用
    static{
        //1.druid连接池技术需要手动加载 配置文件
        Properties pro=new Properties();
        try {
            pro.load(JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
            //不需要获取 相关的信息 url,name ,password 之类的 直接可以用创建好的连接对象
              dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取数据库连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //获取 连接池
    public static DataSource getDataSource() {
        return dataSource;
    }

    //关闭资源 -DQL 查
    public static void close(ResultSet res, Statement stat, Connection con) {
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

    //关闭资源 DML 增删改
    public static void close(Statement stat, Connection con) {
        close(null, stat, con);
    }

}
