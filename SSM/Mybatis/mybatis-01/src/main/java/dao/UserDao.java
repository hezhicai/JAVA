package dao;

import domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UserDao {
    //1.查询用户
    public List<User> listUser();
    //1.1create
     public void insertUser(HashMap<String,Object> map);
     public void insertUser2(ArrayList<User> list);

     //1.2read
    public  User readUser(HashMap<String,Object> map);
    public  User readUser1(@Param("name") String name,@Param("pwd") String pwd);
    //1.3Update
    public void updateUser(HashMap<String,Object> map);
    //1.4delete
    public  void deleteUser(HashMap<String,Object> map);

    //2.模糊查询
    public List<User> getLikeUser(String value);
    //3.分页查询
    public List<User> getLimitUser(HashMap<String,Integer> map);

}
