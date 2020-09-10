package com.zc.week12.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DB {
	private static DB db=new DB();
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private DB() {
		conn=DBConnection.getConn();
	}
	public static DB getDb(){

		try {
			if(db.conn.isClosed() )
				db=new DB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return db;		
	}
	public int execUpdate(String sql) {
		int rtn=0;
		/*第二题代码补充在此*/
		try {
			stat = conn.createStatement();
			 rtn=stat.executeUpdate(sql);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return rtn;
	}
	
	/**
	 * statement对象执行查询操作
	 * @param sql 需执行的SQL语句
	 * @return ResultSet 查询的结果在记录集返回
	 */
	public ResultSet execSelect(String sql) {
		/*第三题代码补充在此*/
		try {
			 stat = conn.createStatement();
			 rs = stat.executeQuery(sql);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * PreparedStatement对象执行查询操作
	 * @param sql 需执行的SQL语句
	 * @param args 变长参数，为SQL语句的通配符赋值
	 * @return ResultSet 查询的结果在记录集返回
	 */
	public ResultSet execSelect2(String sql,String... args) {
		/*第四题代码补充在此*/
		try {
			pstat = conn.prepareStatement(sql, args);
			pstat.setString(1,args[0]);
			 rs = pstat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	

	
	/**
	 * PreparedStatement对象添加、删除、更新操作
	 * @param sql 需执行的SQL语句
	 * @param args 变长参数，为SQL语句的通配符赋值
	 * @return -1出现异常
	 */
	public int execUpdate2(String sql,String... args) {
		int rtn=0;
		/*第五题代码补充在此*/
		try {
			 pstat=conn.prepareStatement(sql,args);
			for (int i = 0; i < args.length; i++) {
				pstat.setString(i+1, args[i]);
			}

			 rtn = pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rtn;
	}
		
	
	
	
	
	//关闭连接对象   
    public void setConnClose() {
        try{	            
        	conn.close();
		    }catch (Exception e) {}
	}
  
  //关闭所有的资源  
    public void freeCon(){
        try {
          if (rs!=null)
            rs.close() ;
          if(conn!=null)
          	conn.close();
        }
        catch (SQLException ex) {
        }
    }

}
