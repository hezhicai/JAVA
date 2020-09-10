package daoTest;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test01 {

    static Logger logger=Logger.getLogger(Test01.class);

    //查询
    @Test
    public void selectTest(){

        if (logger.isInfoEnabled()){
            logger.debug("System ….info.");
        }

        //1.获取sql会话
        try(SqlSession sqlSession = MybatisUtils.getSqlSession(); ){
            //2.获取mapper对象
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            //查询所有用户
            List<User> users = mapper.listUser();
            for (User user : users) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //插入
    @Test
    public void insertTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession(); ){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("name","theshy2");
            map.put("pwd","123456");
            mapper.insertUser(map);
    }catch (Exception e){
        e.printStackTrace();
        }
    }
    //多行插入
    @Test
    public void insertTest2(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession(); ){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            ArrayList<User> users = new ArrayList<>();
            User user1 = new User();
            user1.setName("一号");
            user1.setpwd("二号");
            User user2 = new User();
            user2.setName("二号");
            user2.setpwd("二号");
            users.add(user1);
            users.add(user2);
            mapper.insertUser2(users);
            sqlSession.commit();
    }catch (Exception e){
        e.printStackTrace();
        }
    }

    //读取用户
    @Test
    public void readTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession();){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String,Object>  map=new HashMap<String,Object>();
            map.put("name","李四");
            User user = mapper.readUser(map);
            System.out.println(user);
    }catch (Exception e){
        e.printStackTrace();
        }
    }
    @Test
    public void readTest1(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession();){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String,Object>  map=new HashMap<String,Object>();
            User user = mapper.readUser1("李四","987654");
            System.out.println(user);
    }catch (Exception e){
        e.printStackTrace();
        }
    }
    //更新用户
    @Test
    public void updateTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession();){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String,Object>  map=new HashMap<String,Object>();
            map.put("oldName","狂神");
            map.put("newName","才神");
            map.put("pwd","asdqwe");
            mapper.updateUser(map);
    }catch (Exception e){
        e.printStackTrace();
        }
    }
    //删除用户
    @Test
    public void deleteTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession();){
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String,Object>  map=new HashMap<String,Object>();
            map.put("name","hzc123");
            mapper.deleteUser(map);
    }catch (Exception e){
        e.printStackTrace();
        }
    }

    //模糊查询
    //查询
    @Test
    public void getLikeTest(){
        //1.获取sql会话
        try(SqlSession sqlSession = MybatisUtils.getSqlSession(); ){
            //2.获取mapper对象
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            //3.添加sql通配符
            String wildcardname="张";
            List<User> likeUser = mapper.getLikeUser(wildcardname);
            //打印
            for (User user : likeUser) {
                System.out.println(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //分页查询
    @Test
    public void getLimitTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            final UserDao mapper = sqlSession.getMapper(UserDao.class);
            final HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("startIndex", 2);
            hashMap.put("pageSize", 4);
            final List<User> limitUser = mapper.getLimitUser(hashMap);
            for (User user : limitUser) {
                System.out.println(user);
            }
        }catch (Exception e){
            logger.debug(e.getMessage());
        }

    }

}
