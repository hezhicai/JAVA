package com.zc.week12.util;
import java.sql.*;

public class DBConnection {
	/*第一题：补充完整DBConnection类中的getConn()方法，
     *实现加载驱动类并通过驱动管理器类的getConnection()方法
     *获得Connection连接对象并返回
     */
	public static Connection getConn()  {
		// 连接sqlserver数据库驱动程序的写法
		// String CLASSFORNAME="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// 连接Mysql数据库驱动程序的写法
		String CLASSFORNAME = "com.mysql.jdbc.Driver";

		// 定义URL，数据库访问的地址
		// String DBURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=addressbook";
		String DBURL = "jdbc:mysql:///addressbook?characterEncoding=GBK";

		// 定义数据库用户名和密码
		// String DBUSER="sa";
		// String DBPWD="123";
		String DBUSER = "root";
		String DBPWD = "123";

		Connection conn = null;
		/*第一题代码补充在此*/
		try {
			 conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return conn;
	}
}
