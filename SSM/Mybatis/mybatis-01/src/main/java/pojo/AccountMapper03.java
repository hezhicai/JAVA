package pojo;

import domain.AccountUser;
import domain.User;

import java.util.List;
/**
 * 一级缓存
 */


public interface AccountMapper03 {


    /**
     * user   根据id查询用户信息
     */
    public User getUserById(Integer id);
/**
 *更新用户
 */

public void  updateUser(User user);
}
