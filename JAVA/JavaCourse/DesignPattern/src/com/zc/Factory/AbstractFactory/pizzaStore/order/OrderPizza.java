/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.Factory.AbstractFactory.pizzaStore.order;
/*
 *@Author:
 *@CreateTime:2020-05-19-32
 *@description:实现对不同工厂的聚合
 */
import com.zc.Factory.AbstractFactory.pizzaStore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public  class OrderPizza {
   AbstractSimpleFactory abstractSimpleFactory;//抽象工厂
    //构造器中放入操作  ---
    public OrderPizza(AbstractSimpleFactory abstractSimpleFactory){
        setFactory(abstractSimpleFactory);
        this.abstractSimpleFactory=abstractSimpleFactory;
    }
    //选择加工厂
    public void setFactory(AbstractSimpleFactory abstractSimpleFactory){
      while(true){
            //获取用户的输入pizza类型
            String orderType=orderType();
            //接收披萨类型
            Pizza pizza = this.abstractSimpleFactory.createPizza(orderType);
            //进行一次 pizza判空 以免发生空指针引用
            if(pizza!=null){
        //披萨生产流程
        pizza.prepare();
        pizza.baking();
        pizza.slice();
        pizza.box();}else{
                System.out.println("输入有误!!!");
            }}    }
   //2.对输入进行判别
   public String orderType()  {
       //从电脑中输入
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       try {
           System.out.println("请输入披萨种类(奶酪味/胡椒粉味):");
           String str = br.readLine();
           return str;
       } catch (IOException e) {
           e.printStackTrace();
           return "";
       }
   }
}
