package mybatis.utils;

import mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * 利用数据源建立连接的工具类
 */

public class DataSourceUtil {

    /**
     * 通过自定义的配置类 获取连接
     * @param cfg
     * @return
     */

    public static Connection getConnection(Configuration cfg)  {
        try {
            //1.加载驱动
            Class.forName(cfg.getDriver());
            //2.获取连接
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
