/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.week11ProducerConsumer.awaitSignal;/*
 *@Author:
 *@CreateTime:2020-05-00-25
 *@description:
 */
public class Demo {
    public static void main(String[] args) {
        //创建共享资源 果盘
        FruitePlate fruitePlate=new FruitePlate();
        //创建生产者 爸妈
        Producer producer1=new Producer(fruitePlate);
        Producer producer2=new Producer(fruitePlate);
        producer1.setName("爸爸");
        producer2.setName("妈妈");
        //创建消费者 儿女
        Comsumer comsumer1=new Comsumer(fruitePlate);
        Comsumer comsumer2=new Comsumer(fruitePlate);
        comsumer1.setName("女儿");
        comsumer2.setName("儿子");
        //四个子线程开始
        producer1.start();
        producer2.start();
        comsumer1.start();
        comsumer2.start();

    }
}
