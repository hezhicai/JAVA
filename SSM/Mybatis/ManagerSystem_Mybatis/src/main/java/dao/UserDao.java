package dao;

import domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserDao {


    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 增加用户
     * @param user
     */
    @Insert("insert into user(name,gender,age,address,qq,email) values(#{name},#{gender},#{age},#{address},#{qq},#{email})")
    public void add(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    void delete(int id);

    /**
     * 修改用户信息
      * @param id
     * @return
     */
    @Update("update user set name=#{name},gender=#{gender},age=#{age},qq=#{qq},email=#{email} where id=#{id}")
    void update(User user);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User getUser(int id);

    /**
     * 获取所有用户表 条件+模糊 查询下 所有的记录的条数
     * @param condition key:条件名称  value：用户填写的参数
     * @return
     */
    int getTotalCount(Map<String, String[]> condition);

    /**
     * 条件查询 当前页面下的用户
     * @param first  当前页码的第一条记录的编号
     * @param rows  每页的记录行数
     * @param condition
     * @return
     */
    List<User> getListByPage(@Param("first") int first,@Param("rows") int rows,@Param("condition") Map<String, String[]> condition);

}
