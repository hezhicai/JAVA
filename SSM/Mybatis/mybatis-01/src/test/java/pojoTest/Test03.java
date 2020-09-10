package pojoTest;

import domain.AccountUser;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.AccountMapper02;
import pojo.AccountMapper03;

import java.io.InputStream;
import java.util.List;

/**
 * 一级缓存sqlSession
 */
public class Test03 {
    private InputStream in;
    private SqlSession session;
    private  AccountMapper03 mapper;

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
                 mapper = session.getMapper(AccountMapper03.class);
            }
    /**
     * 证明一级缓存真的的存在
      */
    @Test
    public void testFirstLevelCache(){
    User user01 = mapper.getUserById(3);
    User user02 = mapper.getUserById(3);
    System.out.println(user01==user02);
    //Preparing: select * from user where id=?  只执行了一次
}
/**
 * 测试 一级缓存的清空  是否有效
 */
@Test
public void testFirstLevelClearCache() {
    User user01 = mapper.getUserById(3);
    //进行缓存清空  操作(或者commit,close等修改操作)
    session.clearCache();
    final AccountMapper03 mapper2 = session.getMapper(AccountMapper03.class);
    User user02 = mapper2.getUserById(3);
    System.out.println(user01 == user02);//false---Executor两次的new的实例不同
    // Preparing: select * from user where id=?   执行了两次
}
/**
 * 查看同步操作情况下  是否会更新缓存
 */
@Test
public void testSynFirstLevelCache() {
    User user01 = mapper.getUserById(3);
    System.out.println(user01);
    user01.setName("更新 操作 ");
    user01.setpwd("缓存会更新吗");
    mapper.updateUser(user01);
    User user02 = mapper.getUserById(3);
    System.out.println(user02);
    System.out.println(user01 == user02);//false
    //  进行了两次 数据库 操作  ，说明进行同步的sql操作时 会 进行缓存的更新，防止出现脏读情况
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

