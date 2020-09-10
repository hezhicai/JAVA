package pojo;

import domain.User;

/**
 * 二级缓存
 */


public interface AccountMapper04 {


    /**
     * user   根据id查询用户信息
     */
    public User getUserById(Integer id);
/**
 *更新用户
 */

public void  updateUser(User user);
}
