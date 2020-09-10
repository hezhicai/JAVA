package dao;

import domain.User;
import mybatis.annotations.Select;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
}
