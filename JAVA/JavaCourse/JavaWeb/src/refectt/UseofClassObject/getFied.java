package refectt.UseofClassObject;
import java.lang.reflect.Field;
public class getFied {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //1.获取类对象
        Class stu = Student.class;
        //2.通过类对象获取成员变量 --参数是成员变量的名字
       // Field na = stu.getField("name");//只能获取 public类型
        Field na = stu.getDeclaredField("name");//获取非private的
        na.setAccessible(true);//暴力反射 private修饰的可以访问
        System.out.println(na);//结果:public java.lang.String refectt.UseofClassObject.Student.name
        //3.为成员变量赋值 或者取值
        Student s=new Student();//成员变量所属类对象
        Object o = na.get(s);
        System.out.println(o);//结果:何小小
         na.set(s,"何大大");
        System.out.println(na.get(s));//结果:何小小
    }
}
