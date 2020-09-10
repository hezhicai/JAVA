package pojoTest;

import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.AccountMapper03;
import pojo.AccountMapper04;

import java.io.InputStream;

/**
 * 二级缓存  存放在SqlSessionFactory
 */
public class Test04 {
    private InputStream in;
     SqlSessionFactory factory;
    /**
     * 获取资源 加载资源 解析资源 获得连接
     */
    @Before
    public void init() throws  Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("mybatis-01.xml");
        //2.获取factory
        factory = new SqlSessionFactoryBuilder().build(in);
    }

/**
 * 查看二级缓存
 */
@Test
public void testSynFirstLevelCache() {
     SqlSession sqlSession1 = factory.openSession();
     AccountMapper04 mapper1 = sqlSession1.getMapper(AccountMapper04.class);
    User user01 = mapper1.getUserById(3);
    System.out.println(user01);
    sqlSession1.commit();

    SqlSession sqlSession2 = factory.openSession();
    AccountMapper04 mapper2 = sqlSession1.getMapper(AccountMapper04.class);
    User user02 = mapper1.getUserById(3);
    System.out.println(user02);
    sqlSession2.commit();
    System.out.println(user01 == user02);// false 二级缓存的是数据 不是对象 （通过封装数据new 对象）
    //  进行了一次 数据库 操作
}
    /**
     * 关闭资源
     */
    @After
    public void destroy() throws Exception{

        in.close();
    }



    }

