package Annotation.useAnnotation;
/*
编写一个 加减乘除 的计算器 类
在每个方法中使用check注解：
* */
public class Calcutor {
    @check
    public void add(){
        System.out.println("1+0:"+(1+0));
    }
    @check
    public void remove(){
        System.out.println("1-0:"+(1-0));
    }
    @check
    public void muptiply(){
        System.out.println("1*0:"+(1*0));
    }
    @check
    public void div(){
        System.out.println("1/0:"+(1/0));
    }
}
