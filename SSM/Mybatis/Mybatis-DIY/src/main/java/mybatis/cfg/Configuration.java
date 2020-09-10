package mybatis.cfg;


import java.util.HashMap;
import java.util.Map;

/**
 * 自定义配置文件
 */
public class Configuration {
    //连接信息
    private String driver;
    private String url;
    private String username;
    private String password;
    //映射信息
    private final Map<String, Mapper> mappers=new HashMap<String, Mapper>();
    //方法
    public Map<String, Mapper> getMappers(){
        return mappers;
    }
    public void setMappers(Map<String, Mapper> mappers){
        this.mappers.putAll(mappers);//此处需要使用追加的方式
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
