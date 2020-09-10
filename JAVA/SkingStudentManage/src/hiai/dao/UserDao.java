package hiai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hiai.model.User;
/**
 * �û���½��
 *
 */
public class UserDao {
	/**
	 * ��¼��֤���ж��û����������Ƿ���ȷ
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from user_login where username=? and password=?";//�������ݿ�Ľӿ�
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassWord());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassWord(rs.getString("passWord"));
		}
		return resultUser;
	}
}
