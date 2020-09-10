/*
 *
 *
 */
package com.zc.dataSource.druid.demo;/*
 *@Author:
 *@CreateTime:2020-05-18-31
 *@description:
 */
import com.zc.dataSource.druid.utils.JDBCutils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class druidDemo01 {
    public static void main(String[] args) {
        PreparedStatement ps=null;
        Connection con=null;
        try {
            con = JDBCutils.getConnection();
            String sql = "insert into student values(?,?,?)";//防止sql注入
            ps = con.prepareStatement(sql);
            ps.setString(1,"2004");
            ps.setString(2,"老何");
            ps.setString(3,"男");
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutils.close(ps, con);
        }
    }
}
