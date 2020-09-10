package refectt.UseofClassObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class getConstructor {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.获取类对象/引用
        Class stu = Student.class;

        //2.通过类对象获取构造方法 --参数是构造器中的类对象
        Constructor  cstr = stu.getDeclaredConstructor(String.class,char.class);
        Constructor  cstr2 = stu.getDeclaredConstructor(String.class,int.class);
        //3.通过构造方法赋值
        Object o1 = stu.newInstance();//空参的情况可以直接实例化对象
        Object o2 = cstr.newInstance("呵呵",'女');
        Object o3 = cstr2.newInstance("呵呵何",18);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
    }
}
