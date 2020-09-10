package pojo;

import domain.UserAccount;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 *
 *   mybatis 基于注解方式实现配置二级缓存 @CacheNamespace
 *
 *  @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface IUserPojo {

    /**
     * 查询所有用户         延迟加载的方式
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "pwd" ,property = "pwd"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "pojo.IAccountDao.findAccountByUid",
                                fetchType = FetchType.LAZY))
    })
    List<UserAccount> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    @ResultMap("userMap")
    UserAccount findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where name like #{name} ")
    @ResultMap("userMap")
    List<UserAccount> findUserByName(String username);


}
