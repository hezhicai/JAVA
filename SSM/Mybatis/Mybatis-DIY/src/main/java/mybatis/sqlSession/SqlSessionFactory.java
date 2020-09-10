package mybatis.sqlSession;

import mybatis.sqlSession.defaults.DefaultSqlSession;

public interface SqlSessionFactory {
    /**
     *
     * @return:获取新的sql会话
     */
    DefaultSqlSession openSession();
}
