package hiai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hiai.model.GradeType;
import hiai.util.StringUtil;
/**
 * 班级类别类
 * 主要对班级添加、删除、更新、查询的一些操作
 */
public class GradeTypeDao {
	/**
	 * 班级添加
	 */
	public int add(Connection con,GradeType gradeType)throws Exception{
		String sql="insert into grade values(null,?,?,?)";//班级添加sql语句
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gradeType.getGradeXue());
		pstmt.setString(2, gradeType.getGradeName());
		pstmt.setString(3, gradeType.getGradeDesc());
		return pstmt.executeUpdate();
	}
	/**
	 * 
	 * 查询班级集合
	 */
	public ResultSet list(Connection con,GradeType gradeType)throws Exception{
		StringBuffer sb=new StringBuffer("select * from grade");
		if(StringUtil.isNotEmpty(gradeType.getGradeName())){
			sb.append(" and gradeName like '%"+gradeType.getGradeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	/**
	 * 班级删除
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from grade where id=?";//删除sql
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/**
	 * 班级修改
	 */
	public int update(Connection con,GradeType gradeType)throws Exception{
		String sql="update grade set gradeXue=?,gradeName=?,gradeDesc=? where id=?";//修改Sql
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gradeType.getGradeXue());
		pstmt.setString(2, gradeType.getGradeName());
		pstmt.setString(3, gradeType.getGradeDesc());
		pstmt.setInt(4, gradeType.getId());
		return pstmt.executeUpdate();
	}
}

