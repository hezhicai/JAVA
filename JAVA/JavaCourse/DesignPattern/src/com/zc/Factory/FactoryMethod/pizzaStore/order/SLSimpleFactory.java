/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.Factory.FactoryMethod.pizzaStore.order;
import com.zc.Factory.FactoryMethod.pizzaStore.pizza.Pizza;
import com.zc.Factory.FactoryMethod.pizzaStore.pizza.SLCheesePizza;
import com.zc.Factory.FactoryMethod.pizzaStore.pizza.SLPepperPizza;

/*
 *@Author:
 *@CreateTime:2020-05-19-39
 *@description:上饶加工厂
 */
public class SLSimpleFactory extends  OrderPizza{
    Pizza pizza=null;
    @Override
    public Pizza createPizza(String orderType) {
        if(orderType.equals("上饶奶酪味披萨")){
            pizza=new SLCheesePizza();
        }else if(orderType.equals("上饶胡椒粉味的披萨")){
            pizza=new SLPepperPizza();
        }
        return pizza;
    }
}
