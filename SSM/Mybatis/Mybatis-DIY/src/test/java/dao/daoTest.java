package dao;

import domain.User;
import mybatis.io.Resources;
import mybatis.sqlSession.SqlSession;
import mybatis.sqlSession.SqlSessionFactory;
import mybatis.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

public class daoTest {
            //查询所有
    @Test
    public void getList(){
        try {
            //加载配置文件
            final InputStream resources = Resources.getResourcesAsStream("sqlMapConfig.xml");
            //解析配置文件
            final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resources);
            //获取sqlSession
            final SqlSession sqlSession = sqlSessionFactory.openSession();

            //获取mapper代理对象 执行sql
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            //代理对象增强 查询方法
            final List<User> users = mapper.getUsers();
            //遍历
            for (User user : users) {
                System.out.println(user);
            }
            //关闭sql会话技术
            sqlSession.close();
            //关闭流
            resources.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
