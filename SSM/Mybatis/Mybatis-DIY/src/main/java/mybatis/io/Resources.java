package mybatis.io;

import java.io.InputStream;

/**
 * 通过通过类加载器加载配置文件
 */

public class Resources {

/**
 * @param:资源路径
 * @return :得到输入流
 */
public static InputStream getResourcesAsStream(String filepath){

    return Resources.class.getClassLoader().getResourceAsStream(filepath);
}
}
