/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.simpleFactory.pizzaStore.pizza;/*
 *@Author:
 *@CreateTime:2020-05-17-24
 *@description:希腊披萨
 */

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("希腊味的披萨正在准备中");
    }
}
