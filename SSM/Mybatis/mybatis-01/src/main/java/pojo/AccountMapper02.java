package pojo;

import domain.*;

import java.util.List;
/**
 * 懒加载
 */

/**
 * account接口
 */
public interface AccountMapper02 {
    /**
     * 查询所有账户 并显示 用户名     一对一
     */

    public List<AccountUser> listAccount();

    /**
     * user   根据id查询用户信息
     */
    public User getUserById(Integer id);


}
