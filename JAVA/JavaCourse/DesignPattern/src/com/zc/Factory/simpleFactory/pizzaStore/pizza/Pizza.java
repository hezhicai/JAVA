/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.Factory.simpleFactory.pizzaStore.pizza;/*
 *@Author:
 *@CreateTime:2020-05-17-13
 *@description:简单工厂模式
 */
//抽象pizza类
public abstract class Pizza {
     protected String name;//pizza种类名
    //pizza的制作生产的四个流程
    //1.pizza的准备过程
    public abstract  void prepare();
    //2.pizza的烘焙过程
    public void baking(){
        System.out.println(name+"正在烘焙");
    }
     //3.pizza的切片过程
    public void slice(){
        System.out.println(name+"正在切片");}
        //4.pizza的打包装箱过程
    public void box(){
        System.out.println(name+"正在装箱");
    }

    public void setName(String name) {
        this.name = name;
    }

}




