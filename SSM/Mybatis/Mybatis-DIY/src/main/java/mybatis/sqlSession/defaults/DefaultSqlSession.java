package mybatis.sqlSession.defaults;

import mybatis.cfg.Configuration;
import mybatis.sqlSession.Proxy.MapperProxy;
import mybatis.sqlSession.SqlSession;
import mybatis.utils.DataSourceUtil;

import java.io.UncheckedIOException;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * sqlsession接口的实现类
 */

public class DefaultSqlSession  implements SqlSession {
        private final Configuration cfg;
        private final Connection connection;



    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection= DataSourceUtil.getConnection(cfg);
    }

    /**
     *创建代理对象
     * @param daoInterfaceClass ：dao接口的字节码对象
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
//        daoInterfaceClass.getInterfaces()-->new Class[]{daoInterfaceClass

        final   Object proxyInstance = Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));
        return  (T)proxyInstance;
    }

    /**
     * 关闭资源
     */
    @Override
    public void close() {
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
