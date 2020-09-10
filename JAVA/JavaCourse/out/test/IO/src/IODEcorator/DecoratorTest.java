package IODEcorator;
/*
 *@Author:${何智才}
 *@CreateTime:2020-04-16-43
 */
/*装饰者设计模式*/
public class DecoratorTest {
    public static void main(String args[]) {
        //儿子画铅笔画
        Work sonWork = new SonWork();
        //妈妈给画上色
        Work motherWork = new MotherWork(sonWork);
        System.out.println(motherWork.mes());
        //爸爸给画装画框
        Work fatherWork = new FatherWork(sonWork);
        System.out.println(fatherWork.mes());
        //爸爸给上了色的画装画框
        Work fatherWork2 = new FatherWork(motherWork);
       System.out.println(fatherWork2.mes());

    }
}

/*抽象组件类*/
abstract class Work {
    //画铅笔画
    public String paint() {

        return "画铅笔画";
    }

    //给铅笔画上色
    public String coloring() {





        return "给铅笔画上色";
    }

    //给铅笔画装画框
    public String install() {

        return "给铅笔画装画框";
    }




    //显示信息
    public abstract String mes();
}
/*具体组件*/
class SonWork extends Work {
    String name = "儿子";//声明操作人

    @Override
    public String mes() {
        return name + super.paint();
    }
}
/*抽象装饰类*/
abstract class Decorator extends Work {
    private Work work;

    //对抽组件的引用
    public Decorator(Work work) {
        this.work = work;
    }

    @Override
    public String mes() {
        return this.work.mes();
    }

    @Override
    public String coloring() {
        return this.work.coloring();
    }

    @Override
    public String install() {
        return this.work.install();
    }
}
/*具体装饰类*/


class FatherWork extends Decorator {
    private String name = "爸爸";
    private Work work;//关联抽象装饰

    //构造具体装饰类
    public FatherWork(Work work) {
        super(work);
    }

    @Override
    public String mes() {
        return super.mes() + "-->" + name + super.install();
    }
}
class MotherWork extends Decorator {
    private String name = "妈妈";

    //构造具体装饰类
    public MotherWork(Work work) {
        super(work);
    }

    @Override
    public String mes() {
        return super.mes() + "-->" + name + super.coloring();
    }


}
