package test;

import dao.IUserDao;
import domain.UserAccount;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 增加   参数user
     *
     */
    @Test
    public void testSave(){
        UserAccount user = new UserAccount();
        user.setName("mybatis annotation");
        user.setPwd("abcdefg");

        userDao.saveUser(user);
    }

    /**
     * 修改  参数 user
     */
    @Test
    public void testUpdate(){
        UserAccount user = new UserAccount();
        user.setId(8);
        user.setName("北京市海淀区");
        user.setPwd("123123");

        userDao.updateUser(user);
    }

    /**
     * 删除  参数 id
     */

    @Test
    public void testDelete(){
        userDao.deleteUser(8);
    }

    /**
     *  查找 参数 id
     */
    @Test
    public void testFindOne(){
        UserAccount user = userDao.findById(2);
        System.out.println(user);
    }

    /**
     * 模糊查找   参数 name
     */
    @Test
    public  void testFindByName(){
//        List<User> users = userDao.findUserByName("%mybatis%");
        List<UserAccount> users = userDao.findUserByName("张老");//张老板
        for(UserAccount user : users){
            System.out.println(user);
        }
    }

    /**
     * 聚合函数   返回值：用户数
     */
    @Test
    public  void testFindTotal(){
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
