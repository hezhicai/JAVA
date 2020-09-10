package WideChard;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<? super C> arr=new ArrayList<>();
        arr.add(new C());
        //为什么不能向List<? super C>存入A B Object类型，而可以存入C和D E？
        //因为存入A B或者Object类型可能会破坏原来List的类型一致性，
        // 正是为了避免这个问题才在JDK5引入泛型特性的，因此不能允许。
        // 而存入C的子类时，通过隐式转换为C可以保证不因此破坏List中item类型的一致。
        Object object = arr.get(1);
//        什么List<? super C> param取出来的是Object，而不是具体类型？
//        因为在声明param的时候只要求这个param是List<? super C>，
//        翻译成人话就是声明param是List<B>,List<A>,List<C>,List<Object>或者
//        是List<? super B>,List<? super A>中的一种，不能保证是具体的哪一种，
//        所以编译器不知道取出的item是哪一种具体类型。
//        如果程序员自己能够保证传入的是同一种具体类型的item，那么自行强制转型，
//        但是编译器只能简单地约定从List<? super C>中取出的Object类型
        ArrayList<? extends  C> arr2=new ArrayList<>();
//        不可以向其中添加任何具体类型，除了null。
//道理和List<Object>不能接受List<String>向上转型一样，
// add任何具体类型可能破坏泛型原有的类型一致性，禁止。
        C c = arr2.get(1);
//        可以读到具体类型
//        仅支持 读取  不支持写入
    }
}
