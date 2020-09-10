package Annotation;
@SuppressWarnings("all")//注解的属性名只为 value 可以直接赋值 不要指定名字
public class jdkAnnotation {

    @Override
    public String toString(){

        return "说";
    }
    @Deprecated
    public  String listen(){
        return "听";
    }

    public String read(){
        return "读";

    }
}
