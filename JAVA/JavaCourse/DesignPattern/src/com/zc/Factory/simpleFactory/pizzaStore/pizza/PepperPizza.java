/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.simpleFactory.pizzaStore.pizza;/*
 *@Author:
 *@CreateTime:2020-05-17-24
 *@description:胡椒粉披萨
 */

public class PepperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("胡椒粉味的披萨正在准备中");
    }
}
