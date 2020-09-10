package hiai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hiai.model.Student;
/**
 * ѧ��Dao��
 * ��ѧ������ӡ�ɾ�����޸�
 */
public class StudentDao {
	/**
	 * ѧ�����
	 */
	public int add(Connection con,Student student) throws  Exception{
		String sql="insert into student values(null ,?,?,?,?,?,?,?,?)";//null
		PreparedStatement pstmt= null;

			pstmt = con.prepareStatement(sql);

		pstmt.setString(1, student.getStuName());
		pstmt.setString(2, student.getStuXue());
		pstmt.setString(3, student.getStuIdcard());
		pstmt.setString(4, student.getStuSex());
		pstmt.setString(5, student.getStuAge());
		pstmt.setString(6, student.getStuAddress());
		pstmt.setString(7, student.getStuPhone());
		pstmt.setInt(8, student.getStuTypeid());
		return pstmt.executeUpdate();
	}
}
