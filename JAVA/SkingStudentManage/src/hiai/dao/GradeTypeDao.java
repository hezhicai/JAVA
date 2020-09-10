package hiai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hiai.model.GradeType;
import hiai.util.StringUtil;
/**
 * �༶�����
 * ��Ҫ�԰༶��ӡ�ɾ�������¡���ѯ��һЩ����
 */
public class GradeTypeDao {
	/**
	 * �༶���
	 */
	public int add(Connection con,GradeType gradeType)throws Exception{
		String sql="insert into grade values(null,?,?,?)";//�༶���sql���
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gradeType.getGradeXue());
		pstmt.setString(2, gradeType.getGradeName());
		pstmt.setString(3, gradeType.getGradeDesc());
		return pstmt.executeUpdate();
	}
	/**
	 * 
	 * ��ѯ�༶����
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
	 * �༶ɾ��
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from grade where id=?";//ɾ��sql
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/**
	 * �༶�޸�
	 */
	public int update(Connection con,GradeType gradeType)throws Exception{
		String sql="update grade set gradeXue=?,gradeName=?,gradeDesc=? where id=?";//�޸�Sql
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gradeType.getGradeXue());
		pstmt.setString(2, gradeType.getGradeName());
		pstmt.setString(3, gradeType.getGradeDesc());
		pstmt.setInt(4, gradeType.getId());
		return pstmt.executeUpdate();
	}
}

