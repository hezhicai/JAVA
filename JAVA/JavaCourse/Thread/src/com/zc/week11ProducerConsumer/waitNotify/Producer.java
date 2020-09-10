/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.week11ProducerConsumer.waitNotify;/*
 *@Author:
 *@CreateTime:2020-05-00-25
 *@description:生产者线程：爸爸,妈妈
 */
public class Producer extends  Thread{
    //对果盘的引用
    private FruitePlate fruitePlate;
    public Producer(FruitePlate fruitePlate){
        this.fruitePlate=fruitePlate;
    }
    @Override
    public void run() {
       //开始进行具体的生产方法
        while(true){
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fruitePlate.produce();
        }
    }
}
