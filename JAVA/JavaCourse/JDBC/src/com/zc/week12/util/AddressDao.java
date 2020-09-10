package com.zc.week12.util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AddressDao {
	/*第二题：添加通讯录信息，将参数对象的信息保存到数据库中
	 * 补充AddressDao类的addAddress()方法，在方法中
	 * 调用DB类的execUpdate()方法实现数据库操作
	 * 并补充完整DB类的execUpdate()方法
	 */	
	public static int addAddress(AddressObject addr) {
		int rtn=0;
		/*第二题代码补充在此*/
		String name = addr.getName();
		String tel = addr.getTel();
		String qq = addr.getQq();
		String sql="insert into AddressInfo values(null,'"+name+"','"+tel+"','"+qq+"')";
		rtn = DB.getDb().execUpdate(sql);
		return rtn;
	}
	/*第三题：查询通讯录中的所有信息
	 * 补充AddressDao类的selectAddress()方法，在方法中
	 * 调用DB类的execSelect()方法实现数据库操作             
	 * 并对返回的ResultSet对象的信息封装到List中并返回
	 * 并补充完整DB类的execSelect()方法
	 */
	public static List<AddressObject> selectAddress()  {
		AddressObject addr;
		List<AddressObject> list=new ArrayList<AddressObject>();
		/*第三题代码补充在此*/
		ResultSet res = DB.getDb().execSelect("select * from AddressInfo");//执行查询语句
		try {
			while (res.next()) {
				String name = res.getString("name");//获取列名位name的值
				String tel = res.getString("tel");
				String qq = res.getString("qq");
				addr = new AddressObject(name, tel, qq);
				list.add(addr);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	/*第四题：根据姓名查询通讯录信息
	 * 补充AddressDao类的searchAddr()方法，在方法中
	 * 调用DB类的execSelect2()方法实现数据库操作             
	 * 并对返回的ResultSet对象的信息封装到List中并返回
	 * 并补充完整DB类的execSelect2()方法
	 */
	public static List<AddressObject> searchAddr(String name) {
		AddressObject addr;
		List<AddressObject> list=new ArrayList<AddressObject>();
		/*第四题代码补充在此*/
		try {
			ResultSet rs = DB.getDb().execSelect2("select * from AddressInfo where name=?",name);//使用通配符 报错
			while(rs.next()){
				 name = rs.getString("name");//获取列名位name的值
				String tel = rs.getString("tel");
				String qq = rs.getString("qq");
				addr = new AddressObject(name, tel, qq);
				list.add(addr);
			}
		}catch (SQLException e){e.printStackTrace();}
		return list;
	}
	/*第五题：修改通讯录信息
	 * 补充AddressDao类的updateAddress()方法，在方法中
	 * 调用DB类的execUpdate2()方法实现数据库操作             
	 * 并补充完整DB类的execUpdate2()方法
	 */
	public static int updateAddress(AddressObject addr){		
		int rtn=0;
		/*第五题代码补充在此*/
		String name = addr.getName();
		String tel = addr.getTel();
		String qq = addr.getQq();
		String sql="update AddressInfo set name=?,tel=?,qq=? where name=?";//
		DB.getDb().execUpdate2(sql,name,tel,qq,name);
		return rtn;
	}
	
	/*第六题：删除通讯录信息
	 * 补充AddressDao类的delAddress()方法，在方法中
	 * 调用DB类的execUpdate2()方法实现数据库操作             
	 */
	public static int delAddress(AddressObject addr) {		
		int rtn=0;
		/*第六题代码补充在此*/
		String name = addr.getName();
		/*String tel = addr.getTel();
		String qq = addr.getQq();*/
		String sql="delete from AddressInfo where name=?";//
		DB.getDb().execUpdate2(sql,name);
		return rtn;
	}

}
