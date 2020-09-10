package pojo;

import domain.AccountUser;
import domain.UserAccount;
import domain.UserRole;

import java.util.List;

/**
 * account接口
 */
public interface AccountMapper {
    /**
     * 查询所有账户 并显示 用户名     一对一
     */

    public List<AccountUser> listAccount();
    /**
     * 查询所有用户 的账户 多对多
     */
    public  List<UserAccount> listUser();

    /**
     * 用户到角色的多对多关系
     * @return  UserRole
     */
    public  List<UserRole> listUserRole();

}
