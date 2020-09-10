/*
 *
 *
 */
package com.zc.springJDBC.JDBCtemplate;

/*
 *@Author:
 *@CreateTime:2020-05-22-05
 *@description:单元测试 ：将类中的方法可以单独执行 无需 main方法
 * JDBctemplate减少手动 去封装查询结果的对象 直接进行 使用就欧克
 */
import com.zc.dataSource.druid.utils.JDBCutils;
import com.zc.table.student;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
public class templateDemo01 {
    //1. 获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCutils.getDataSource());//getDatabase是数据连接池
    @Test
    public void insert(){
         String sql="insert into student values(?,?,?)";
        int update = template.update(sql, 2004, "老李", "男");
        System.out.println(update);
    }
    @Test
    /*
    * 将一条查询结果 封装为map
    * */
    public void query01(){
           String sql="select * from student where sno=? ";
        Map<String,Object> map=template.queryForMap(sql,2001);
        System.out.println(map);
    }
    @Test
    /*
     * 将多条查询结果 封装为List 相当于 存储了多个map
     * */
    public void query02(){
        String sql="select * from student ";
        List<Map<String,Object>> list=template.queryForList(sql);
        for(Map<String,Object> stu:list){
            System.out.println(stu);

        }
    }
    @Test
    /*
     * 将每个查询结果 封装为student对象  存储到list里面
     * BeanPropertyRowMapper 框架已经帮你实现了 封装 student对象 ，直接new 就可以了
     * */
    public void query03(){
        String sql="select * from student ";
        List<student> list= template.query(sql, new BeanPropertyRowMapper<student>(student.class));//student.class字节码文件类型
        for(student stu:list){
            System.out.println(stu);
        }
    }
    @Test
    /*
     *查询总记录个数---一般用于聚合函数中
     * */
    public void query04(){
        String sql="select count(sno) from student ";
        Long count = template.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
