package GenericMethold;

public class ObjectTool {
//    创建泛型方法
    public <T> void show(T t){
        System.out.println(t);//打印字符串
        System.out.println(t.getClass().getName());//打印类型
    }
//    调用泛型方法
    public static void main(String[] args) {
        //创建对象
        ObjectTool tool = new ObjectTool();
        //调用方法,传入的参数是什么类型,返回值就是什么类型
        tool.show("string");  //返回String类型
        int a=3/0;
        Object oo=null;
        oo.toString();
        tool.show(8);   //返回int类型
        tool.show(8.8);   //返回 double类型
    }
}
