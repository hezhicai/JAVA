package refectt.UseofClassObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class getMethold {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.引用student类对象
        Class stu = Student.class;
        //2.获取student对象中的方法
        Method getName = stu.getDeclaredMethod("like");
        Method getName2 = stu.getDeclaredMethod("like2",String.class);//参数是方法里面的类
        //3.执行获取的方法
        Student s=new Student();
        getName.invoke(s);//注意:不能执行重写的方法
        getName2.invoke(s,"niu niu");//不能执行重写的方法
        //4.获取所有方法
        Method[] declaredMethods = stu.getDeclaredMethods();
        for(Method m:declaredMethods ){
            System.out.println(m);
        }

        //4.结果:
        //ublic java.lang.String refectt.UseofClassObject.Student.toString()
        //public java.lang.String refectt.UseofClassObject.Student.getName()
        //public void refectt.UseofClassObject.Student.setName(java.lang.String)
        //public char refectt.UseofClassObject.Student.getSex()
        //public void refectt.UseofClassObject.Student.setSex(char)
        //public int refectt.UseofClassObject.Student.getAge()
        //public void refectt.UseofClassObject.Student.setAge(int)
        //public void refectt.UseofClassObject.Student.like2(java.lang.String)
        //public void refectt.UseofClassObject.Student.like()
    }
}
