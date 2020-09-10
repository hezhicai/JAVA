package pojoTest;

import domain.Account;
import domain.AccountUser;
import domain.UserAccount;
import domain.UserRole;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.AccountMapper;
import pojo.AccountMapper02;

import java.io.InputStream;
import java.util.List;

/**
 * 表的关系
 */
public class Test02 {
    private InputStream in;
    private SqlSession session;
    private  AccountMapper02 mapper;

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
                 mapper = session.getMapper(AccountMapper02.class);
            }
    /**
     * 一对一的关系   懒加载  关联了用户表
     */
    @Test
    public void accountList(){


            final List<AccountUser> accountUsers = mapper.listAccount();

            //需要打印uid的时候在打印出来
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

