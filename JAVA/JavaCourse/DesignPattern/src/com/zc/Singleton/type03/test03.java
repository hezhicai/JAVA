package com.zc.Singleton.type03;/*
 *@Author:
 *@CreateTime:2020-05-15-53
 单例设计模式之枚举:安全高效
 */

public class test03 {
    public static void main(String[] args) {
        singleton ins=singleton.insatnce;
        singleton ins2=singleton.insatnce;
        System.out.println(ins==ins2);
        ins.hello();ins2.hello();
    }
}
enum singleton{
    //1.单个属性,充当对象
    insatnce;
    //任意方法测试
    public void hello(){
        System.out.println("你好单例模式-枚举型");
    }

}