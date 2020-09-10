package Annotation;

import org.junit.Test;

import java.lang.reflect.Method;

//该注解用在类上才能 获取Students到 类和方法
//@MyAnnotation(className = "Annotation.Student",methodName = "speak")
public class DemoMyAnnotation {
    @Test
    @MyAnnotation(className = "Annotation.Student",methodName = "speak") //报错空指针引用
    public void say() throws NoSuchMethodException {
        //通过注解去加载student类
          //1.解析注解
        //1.1获取class对象
        Class<DemoMyAnnotation> demoMyAnnotationClass = DemoMyAnnotation.class;
        //1.2获取 MyAnnotation注解对象  即拿到注解的一个子类
        Method speak = demoMyAnnotationClass.getMethod("say");
        MyAnnotation an = speak.getAnnotation(MyAnnotation.class);
       // MyAnnotation an= demoMyAnnotationClass.getAnnotation(MyAnnotation.class);
        //2.调用 注解中的抽象方法 获取返回值
        String s = an.className();
        String s1 = an.methodName();
        System.out.println(s);
        System.out.println(s1);
    }

}
