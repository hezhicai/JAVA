/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.AbstractFactory.pizzaStore.order;/*
 *@Author:
 *@CreateTime:2020-05-14-58
 *@description:
 */

import com.zc.Factory.AbstractFactory.pizzaStore.pizza.Pizza;

public abstract class AbstractSimpleFactory {
    public abstract Pizza createPizza(String orderType);
}
