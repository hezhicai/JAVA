/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.Factory.FactoryMethod.pizzaStore.order;/*
 *@Author:
 *@CreateTime:2020-05-00-12
 *@description:南昌工厂
 */

import com.zc.Factory.FactoryMethod.pizzaStore.pizza.NCCheesePizza;
import com.zc.Factory.FactoryMethod.pizzaStore.pizza.NCPepperPizza;
import com.zc.Factory.FactoryMethod.pizzaStore.pizza.Pizza;

public class NCSimpleFactory extends OrderPizza{
    Pizza pizza=null;
    @Override
    public Pizza createPizza(String orderType) {
        if(orderType.equals("南昌奶酪味披萨")){
            pizza=new NCCheesePizza();
        }else if(orderType.equals("南昌胡椒粉味的披萨")){
            pizza=new NCPepperPizza();
        }
        return pizza;
    }
}
