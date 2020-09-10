package dao;

import domain.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CityDaoTest {
    private InputStream in ;
    private SqlSession session;
    private CityDao mapper;
    @Before
    public void init() throws IOException {
        final InputStream in = Resources.getResourceAsStream("sys_mybatis.xml");
        final SqlSession session = new SqlSessionFactoryBuilder().build(in).openSession();
        mapper=session.getMapper(CityDao.class);
    }

    /**
     * 查询所有城市名
     *
     */
    @Test
    public void listCity(){
        final List<City> cities = mapper.findCityAll();
        for (City city : cities) {
            System.out.println(city);
        }
    }
    @After
    public void destroy() throws IOException {
        //session.close();   自动关闭？
       // in.close();
    }

}
