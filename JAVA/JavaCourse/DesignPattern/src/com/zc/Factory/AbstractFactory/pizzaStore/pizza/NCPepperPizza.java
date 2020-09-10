/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.AbstractFactory.pizzaStore.pizza;/*
 *@Author:
 *@CreateTime:2020-05-17-24
 *@description:胡椒粉披萨
 */

public class NCPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("南昌胡椒粉味披萨");
        System.out.println(name+"胡椒粉味的披萨正在准备中");
    }
}
