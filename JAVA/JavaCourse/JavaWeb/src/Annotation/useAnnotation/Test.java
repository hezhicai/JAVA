package Annotation.useAnnotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/*
* 编写 一个测试计算器的小框架
* */
public class Test {
    public static void main(String[] args) throws IOException {
        //1.创建计算器类
        Calcutor cal=new Calcutor();
        //2.获取计算器类的字节码文件
        Class<? extends Calcutor> ac = cal.getClass();
        //3.获取字节码文件的所有方法
        Method[] methods = ac.getMethods();
        int num=0;//异常个数
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            //4.判断方法上是否有注解 有的话就执行
            if (method.isAnnotationPresent(check.class)) {
                try {
                    method.invoke(cal);//某个实例对象
                } catch (Exception e) {
                    //5.捕获异常 异常对象，异常名称，原因
                    num++;
                    bw.write(method.getName() +"出现异常");
                    bw.newLine();
                    bw.write("异常名称"+e.getCause().getClass().getName());  //获取原因对象
                    bw.newLine();
                    bw.write( "异常原因"+e.getCause().getMessage());
                    bw.newLine();;
                    bw.write("------------------");
                }
}
        }
        System.out.println("本次一共出现了"+num+"次异常");
        bw.flush();
        bw.close();

    }

}
