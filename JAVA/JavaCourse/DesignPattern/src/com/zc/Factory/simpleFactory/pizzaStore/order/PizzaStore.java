/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.simpleFactory.pizzaStore.order;/*
 *@Author:
 *@CreateTime:2020-05-21-08
 *@description:进行演示
 */

public class PizzaStore {
    public static void main(String[] args) {
        //工厂实例化
        SimpleFactory simpleFactory=new SimpleFactory();
        //订购操作实例化
        OrderPizza orderPizza=new OrderPizza(simpleFactory);
    }
}
