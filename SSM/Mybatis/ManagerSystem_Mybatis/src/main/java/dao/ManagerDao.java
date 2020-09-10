package dao;

import domain.Manager;

public interface ManagerDao {


    //2.返回管理员信息
    public Manager loginManger(Manager loginUser);
    void add_Manager(Manager manager);
    //9.获取管理员用户
    Manager getManager(String name);
}
