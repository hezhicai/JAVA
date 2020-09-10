package mybatis.sqlSession.Proxy;

import mybatis.cfg.Mapper;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * dao接口的代理对象
 */
public class MapperProxy  implements InvocationHandler {

    //map的key是全限定类名（dao接口） 和 方法名（dao实现类）
    private  Map<String, Mapper> mappers;
    private  Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 通过代理对象增强select方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className+"."+methodName;
        //4.获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5.判断是否有mapper
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6.调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
