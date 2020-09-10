package dao;

import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 模糊查询
 */
public interface UserDao2 {

    /**
     * 条件查询
     */
    public List<User> findUserByCondition(User user);

    /**
     * foreach 查询
     */
    public List<User> findUserByCondition2(ArrayList<String> list);


}
