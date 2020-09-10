/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.FactoryMethod.pizzaStore.pizza;/*
 *@Author:
 *@CreateTime:2020-05-17-24
 *@description:奶酪披萨
 */

public class NCCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("南昌奶酪味披萨");
        System.out.println("南昌奶酪味的披萨正在准备中");
    }
}
