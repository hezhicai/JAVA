/*
 *
 *
 */

package com.zc.dataSource.druid.demo;/*
 *@Author:
 *@CreateTime:2020-05-21-32
 *@description:配置文件 最大容量 最多可以连接10个
 */

import com.zc.dataSource.druid.utils.JDBCutils;

import java.sql.SQLException;

public class druidTest01 {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            try {
                System.out.println(JDBCutils.getConnection());

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
