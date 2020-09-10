/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.Factory.simpleFactory.pizzaStore.order;
import com.zc.Factory.simpleFactory.pizzaStore.pizza.CheesePizza;
import com.zc.Factory.simpleFactory.pizzaStore.pizza.GreekPizza;
import com.zc.Factory.simpleFactory.pizzaStore.pizza.PepperPizza;
import com.zc.Factory.simpleFactory.pizzaStore.pizza.Pizza;
/*
 *@Author:
 *@CreateTime:2020-05-19-39
 *@description:简单工厂-将pizza的每一个实例封装起来
 */
public class SimpleFactory {
       public static Pizza createPizza(String orderType) {
           Pizza pizza = null;
           System.out.println("-----------简单工厂模式-----------");
           switch (orderType) {
               case "奶酪披萨":
                   pizza=new CheesePizza();
                   pizza.setName("奶酪披萨");
                   break;
               case "胡椒粉披萨":
                   pizza=new PepperPizza();
                   pizza.setName("胡椒粉披萨");
                   break;
               case "希腊披萨":
                   pizza=new GreekPizza();
                   pizza.setName("希腊披萨");
                   break;
           }
           return pizza;
       }
}
