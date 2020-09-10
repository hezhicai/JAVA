package dao;

import domain.UserAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author
 * @Company
 * 在mybatis中针对,CRUD一共有四个注解
 *  @Select @Insert @Update @Delete
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<UserAccount> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(name,pwd)values(#{name},#{pwd})")

    void saveUser(UserAccount user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set name=#{name},name=#{name} where id=#{id}")
    void updateUser(UserAccount user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer id);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    UserAccount findById(Integer id);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
//    @Select("select * from user where name like #{name} ")
    @Select("select * from user where name like '%${value}%' ")
    List<UserAccount> findUserByName(String name);

    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user ")
    int findTotalUser();
}
