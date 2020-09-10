package com.zc.Singleton.type01;/*
 *@Author:
 *@CreateTime:2020-05-15-20
 单例模式之双重检查：线程安全，效率高
 */
public class test01 {
    public static void main(String[] args) {
        //模拟多线程环境
        singleton ins = singleton.getInstance();
        singleton ins2 = singleton.getInstance();
    }
}

class  singleton {
    //1.初始化:对象私有化
    //被volatile修饰的变量能够保证每个线程能够获取该变量的最新值，从而避免出现数据脏读的现象。
    //volatile 1.防止重排序（在主内存的位置直接更新，） 2.可见（实时更新）
    private static volatile singleton instance;
    //2.构造器
    private singleton(){}
    //3.提供外部的静态公有方法
    public static  singleton getInstance(){
        if(instance==null){
            synchronized (singleton.class){
                if(instance==null){
                    instance=new singleton();//保证在多线程环境下只创建一个对象
                }
            }
        }
        return instance;
    }
}
