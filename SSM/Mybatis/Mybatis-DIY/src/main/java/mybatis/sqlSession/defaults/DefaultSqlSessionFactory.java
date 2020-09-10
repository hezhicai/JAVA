package mybatis.sqlSession.defaults;

import mybatis.cfg.Configuration;
import mybatis.sqlSession.SqlSessionFactory;

/**
 * SqlSessionFactory的实现类
 */

public class DefaultSqlSessionFactory  implements SqlSessionFactory {
        private final Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    //通过配置参数 返回 sqlSession实例
    @Override
    public DefaultSqlSession openSession() {
    return new DefaultSqlSession(cfg);
    }


}
