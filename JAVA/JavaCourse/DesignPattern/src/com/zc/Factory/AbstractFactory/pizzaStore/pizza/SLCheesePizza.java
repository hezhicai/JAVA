/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.AbstractFactory.pizzaStore.pizza;/*
 *@Author:
 *@CreateTime:2020-05-17-24
 *@description:希腊披萨
 */

public class SLCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("上饶奶酪味披萨");
        System.out.println("上饶奶酪的披萨正在准备中");
    }
}
