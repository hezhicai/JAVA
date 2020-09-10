/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.Factory.simpleFactory.pizzaStore.order;
/*
 *@Author:
 *@CreateTime:2020-05-19-32
 *@description:实现对不同工厂的聚合
 */
import com.zc.Factory.simpleFactory.pizzaStore.pizza.Pizza;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class OrderPizza {
    //对工厂和pizza进行初始化
    Pizza pizza = null;//用于接收工厂类传来的pizza种类
    SimpleFactory simpleFactory = null;//订购类的聚合元素-某一工厂
    //生成订购的构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
        this.simpleFactory = simpleFactory;
    }
  //1.对哪一家的工厂进行订购
   public void setFactory(SimpleFactory simpleFactory){
       //获取用户的输入pizza类型
       String orderType = "";
       //do-while进行多次输入  不同的披萨
do{
    orderType=orderType();
    //接收披萨类型
    pizza = SimpleFactory.createPizza(orderType);
    //进行一次 pizza判空 以免发生空指针引用
    if(pizza!=null){
    //披萨生产流程
       pizza.prepare();
       pizza.baking();
       pizza.slice();
       pizza.box();}else{
        System.out.println("输入有误!!!");
    }}while (true);
   }
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
