package dao;

import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao mapper;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("sys_mybatis.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(UserDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }
    /**
     * crud
     */
    @Test
    public void insert(){
        User user=new User();
        user.setName("我是");
        user.setGender("男");
        user.setAge(18);
        user.setAddress("家里");
        user.setQq("123456");
        user.setEmail("123456@");
        mapper.add(user);
    }
    @Test
    public void delete(){
        mapper.delete(49);
    }
    @Test
    public void update(){
        User user=new User();
        user.setId(3);
        user.setName("欧阳");
        mapper.update(user);
    }
    @Test
    public void select(){
        final List<User> users = mapper.findAll();
    }
    @Test
    public void selectById(){
        final User user = mapper.getUser(3);
    }

/**
 * 模糊条件查询
 */
@Test
public void likeCondition(){
    HashMap<String,String[]> hashMap=new HashMap<String,String[]>();
    String []  name={"欧阳"};
    hashMap.put("name",name);
    int totalCount = mapper.getTotalCount(hashMap);
}
/**
 * 分页查询
 */
@Test
public void likeConditionPage(){
    HashMap<String,String[]> hashMap=new HashMap<String,String[]>();
    int first=4;
    int rows=5;
    String []  name={"欧阳"};
    hashMap.put("name",name);

    final List<User> listByPage = mapper.getListByPage(first,rows,hashMap);
    for (User user : listByPage) {
        System.out.println(user);
    }
}


}
