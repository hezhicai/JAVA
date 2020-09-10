/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.Factory.FactoryMethod.pizzaStore.order;
/*
 *@Author:
 *@CreateTime:2020-05-19-32
 *@description:实现对不同工厂的聚合
 */
import com.zc.Factory.FactoryMethod.pizzaStore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public abstract class OrderPizza {
    //抽象化生产披萨方
    public abstract Pizza createPizza(String orderType);
    //构造器中放入操作  ---
    public OrderPizza(){
        do{
            //获取用户的输入pizza类型
            String orderType=orderType();
            //接收披萨类型
            Pizza pizza = createPizza(orderType);
            //进行一次 pizza判空 以免发生空指针引用
            if(pizza!=null){
        //披萨生产流程
        pizza.prepare();
        pizza.baking();
        pizza.slice();
        pizza.box();}else{
                System.out.println("输入有误!!!");
            }}while(true);}
   //2.对输入进行判别
   public String orderType()  {
       //从电脑中输入
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       try {
           System.out.println("请输入披萨种类:");
           String str = br.readLine();
           return str;
       } catch (IOException e) {
           e.printStackTrace();
           return "";
       }
   }
}
