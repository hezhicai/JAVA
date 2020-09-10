package com.zc.learning;/*
 *@Author:SingleTonDemo
 *@CreateTime:2020-05-09-02
 */

public class singleTonDemo {


}
//线程安全之单例懒汉模式
class Bank {
    public static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class){//同步代码块
                if(instance==null){
                    instance=new Bank();
                }
            }
        }
        return instance;
    }
}