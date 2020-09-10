package mybatis.sqlSession;



import mybatis.cfg.Configuration;
import mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 构建者模式：只关心对象的使用，不关心对象的生成过程
 */

public class SqlSessionFactoryBuilder {
    /**
     * @config:配置文件流的参数
     * 通过流得到默认的工厂实现类
     * @return:DefaultSqlSessionFactory
     */
public SqlSessionFactory build(InputStream config) {
    Configuration cfg= XMLConfigBuilder.loadConfiguration(config);
    return new DefaultSqlSessionFactory(cfg);




}


}
