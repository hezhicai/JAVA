/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.FactoryMethod.pizzaStore.order;/*
 *@Author:
 *@CreateTime:2020-05-21-08
 *@description:进行演示
 */

import java.util.Scanner;

public class PizzaStore {
    public static void main(String[] args) {
        //输入你要选择的加工厂
       Scanner sc=new Scanner(System.in);
       String factory="南昌味";
        System.out.println("请输入南昌味/上饶味");
       factory=sc.next();
        //工厂判定 分别是实例化
        if(factory.equals("南昌味")){
           new NCSimpleFactory();
        }else if(factory.equals("上饶味")){
            new SLSimpleFactory();
        }
    }
}
