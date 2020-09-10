package daoTest;

import dao.UserDao2;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态查询
 */
public class Test02 {
    /**
     * if 条件查询
     */
    @Test
    public void findUserByCondition() {
        try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final UserDao2 mapper = sqlSession.getMapper(UserDao2.class);
            User user = new User();
            user.setName("theshy2");
            user.setpwd("123456");
            final List<User> users = mapper.findUserByCondition(user);
            for (User user1 : users) {
                System.out.println(user1);
            }
        }
    }
/**
 * foreach查询
 */
@Test
public void findUserByCondition2() {
    try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
        final UserDao2 mapper = sqlSession.getMapper(UserDao2.class);
        final ArrayList<String> list = new ArrayList<>();
        list.add("张老板");
        list.add("才神");
        final List<User> users = mapper.findUserByCondition2(list);
        for (User user : users) {
            System.out.println(user);
        }

    }
}


}