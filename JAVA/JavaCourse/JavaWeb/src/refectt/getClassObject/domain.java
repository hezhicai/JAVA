package refectt.getClassObject;

public class domain {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取字节码文件对象的三种方式
        //1.通过 class.forname("全类名") 包括包名
        Class cls1 = Class.forName("refectt.getClassObject.domain");
        //2.通过 类名.class
        Class cls2 = domain.class;
        //3. 通过 类对象.getClass()
        domain dm=new domain();
        Class cls3 = dm.getClass();
        //测试 三个类对象是否相同
        System.out.println(cls1==cls2);//true 得出结论 字节码文件被加载位类对象过程中只执行一次
    }
}
