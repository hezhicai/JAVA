package pojoTest;

import domain.Account;
import domain.AccountUser;
import domain.UserAccount;
import domain.UserRole;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.AccountMapper;
import utils.MybatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * 表的关系
 */
public class Test01 {
    private InputStream in;
    private SqlSession session;
    private  AccountMapper mapper;

    /**
     * 获取资源 加载资源 解析资源 获得连接
     */
    @Before
    public void init() throws  Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("mybatis-01.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        session = factory.openSession();
        //4.获取dao的代理对象
                 mapper = session.getMapper(AccountMapper.class);
            }
    /**
     * 一对一的关系
     */
    @Test
    public void accountList(){


            final List<AccountUser> accountUsers = mapper.listAccount();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
            System.out.println(accountUser.getUser());
            System.out.println("-------------");
        }
        }

    /**
     * 一对多 一个用户多个账户
     */
    @Test
    public void userList(){
        final List<UserAccount> userAccounts = mapper.listUser();
        for (UserAccount userAccount : userAccounts) {
            System.out.println(userAccount);
            System.out.println(userAccount.getAccounts());
            System.out.println("-----------------");
        }
    }
    /**
     * 用户到角色的多对多（相当于 用户到角色的一对多 和 角色到用户的一对多）
     */
    @Test
    public void roleList(){
        final List<UserRole> userRoles = mapper.listUserRole();
        for (UserRole userRole : userRoles) {
            System.out.println(userRole);
            System.out.println(userRole.getRoles());
            System.out.println("-------------------");

        }
    }
    /**
     * 关闭资源
     */
    @After
    public void destroy() throws Exception{
        //查询操作不需要提交事务
        session.commit();
        session.close();
        in.close();
    }



    }

