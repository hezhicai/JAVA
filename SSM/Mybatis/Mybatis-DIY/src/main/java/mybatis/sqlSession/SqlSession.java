package mybatis.sqlSession;

public interface SqlSession {


    /**
     *通过参数获取dao接口的代理对象
     * @param daoInterfaceClass ：dao接口的字节码对象
     * @param <T>
     * @return
     */

    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 关闭资源
     */
    void close();
}
