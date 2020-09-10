package com.zc.Singleton.type02;
/*
 *@Author:
 *@CreateTime:2020-05-15-44
 单例模式之静态内部类：线程安全，效率高
 */

public class test02 {
    public static void main(String[] args) {
        //模拟多线程环境
        singleton ins = singleton.getInstance();
        singleton ins2 = singleton.getInstance();
        System.out.println(ins==ins2);

    }
}
class  singleton {
    //1.私有构造器
    private singleton(){}
    //2.静态内部类
    private  static class singletonInstance{
        private final static singleton instance=new singleton();//静态属性，第一次加载类时初始化 jvm保证其他线程不会进入
    }
    //3.提供外部的静态公有方法
    public static singleton getInstance(){
        return singletonInstance.instance;
    }

}


