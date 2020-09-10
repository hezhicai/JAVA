/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.FactoryMethod.pizzaStore.pizza;/*
 *@Author:
 *@CreateTime:2020-05-23-58
 *@description:
 */

import com.zc.Factory.FactoryMethod.pizzaStore.order.SLSimpleFactory;

public class SLPepperPizza extends Pizza{

    @Override
    public void prepare() {
        setName("上饶胡椒粉味披萨");
        System.out.println("上饶胡椒粉味披萨准备中");
    }
}
