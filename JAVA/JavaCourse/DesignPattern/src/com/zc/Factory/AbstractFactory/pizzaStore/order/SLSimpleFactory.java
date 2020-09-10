/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.Factory.AbstractFactory.pizzaStore.order;
import com.zc.Factory.AbstractFactory.pizzaStore.pizza.Pizza;
import com.zc.Factory.AbstractFactory.pizzaStore.pizza.SLCheesePizza;
import com.zc.Factory.AbstractFactory.pizzaStore.pizza.SLPepperPizza;

/*
 *@Author:
 *@CreateTime:2020-05-19-39
 *@description:上饶加工厂
 */
public class SLSimpleFactory extends AbstractSimpleFactory{
    Pizza pizza=null;
    @Override
    public Pizza createPizza(String orderType) {
        if(orderType.equals("奶酪味")){
            pizza=new SLCheesePizza();
        }else if(orderType.equals("胡椒粉味")){
            pizza=new SLPepperPizza();
        }
        return pizza;
    }
}
