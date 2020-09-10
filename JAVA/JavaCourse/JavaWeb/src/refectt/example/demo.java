package refectt.example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
/*
手写简单的框架
*/
public class demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //一.加载配置文件
        Properties pro=new Properties();
        pro.load(Student.class.getResourceAsStream("refect.properties"));
        //二.通过配置文件 获取相应的对象
        String clName = pro.getProperty("className");
        String mldName = pro.getProperty("metholdName");
        //三.将字节码文件 反射到内存当中
        Class clas = Class.forName(clName);//类名是全名
        //四.获取响应的对象和方法
        Student stu=new Student();
        clas.newInstance();
        clas.getDeclaredMethod(mldName).invoke(stu);
    }
}
