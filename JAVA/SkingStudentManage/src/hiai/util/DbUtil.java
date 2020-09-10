package hiai.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * �������ݿ���
 *
 */
public class DbUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/skingstudentmanager?useSSL=false&serverTimezone=UTC";//���ݿ�����ӵ�ַ
	private String dbUserName="root";//���ݿ��û���
	private String dbPassWord="123";//���ݿ�����
	private String jdbcName="com.mysql.jdbc.Driver";//��������
	
	//���ݿ�����
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
		return con;
	}
	//���ݿ�ر�
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	//�������ݿ��Ƿ�����
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
