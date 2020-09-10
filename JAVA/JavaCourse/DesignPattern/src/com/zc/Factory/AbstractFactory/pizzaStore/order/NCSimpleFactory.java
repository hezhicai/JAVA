/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.AbstractFactory.pizzaStore.order;/*
 *@Author:
 *@CreateTime:2020-05-00-12
 *@description:南昌工厂
 */

import com.zc.Factory.AbstractFactory.pizzaStore.pizza.NCCheesePizza;
import com.zc.Factory.AbstractFactory.pizzaStore.pizza.NCPepperPizza;
import com.zc.Factory.AbstractFactory.pizzaStore.pizza.Pizza;

public class NCSimpleFactory extends AbstractSimpleFactory {
    Pizza pizza=null;
    @Override
    public Pizza createPizza(String orderType) {
        if(orderType.equals("奶酪味")){
            pizza=new NCCheesePizza();
        }else if(orderType.equals("胡椒粉味")){
            pizza=new NCPepperPizza();
        }
        return pizza;
    }
}
