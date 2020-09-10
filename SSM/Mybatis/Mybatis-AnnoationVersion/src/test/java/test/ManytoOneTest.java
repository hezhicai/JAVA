package test;

import domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.IAccountDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 复杂的表关系---延迟加载
 */

public class ManytoOneTest {
    /**
     * 查询用户
     */
    private InputStream in;
    private SqlSession session;
    private IAccountDao mapper;

    @Before
    public  void init() throws IOException {
         InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        session=new SqlSessionFactoryBuilder().build(in).openSession();
        mapper=session.getMapper(IAccountDao.class  );

    }
    /**
     * 查询所有用户---以及所属账户
     */
    @Test
    public void finAccount(){
        List<AccountUser> accouts = mapper.findAll();
        for (AccountUser accout : accouts) {
            System.out.println(accout);
            System.out.println(accout.getUser());
        }
    }
    /**
     * 关闭资源
     */
    public void destroy() throws IOException {
        session.close();
        in.close();
    }
}
