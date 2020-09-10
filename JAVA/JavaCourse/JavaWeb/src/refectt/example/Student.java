package refectt.example;

public class Student {
    //成员变量
  private String name="何小小";
    int age=19;
    char sex='男';
    //构造方法一
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //构造方法二
    public Student(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }
//构造方法三
    public Student(){

    }
    public void like(){
        System.out.println("喜欢");
    }
    public void like2(String str){
        System.out.println("喜欢"+str);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
