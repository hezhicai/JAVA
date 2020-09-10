/*
 * 版权所有(C) ,何智才,2020;
 */
package com.zc.week11ProducerConsumer.ThreadPool;/*
 *@Author:zc.
 *@CreateTime:2020-05-00-25
 *@description:消费者线程.
 */
public class Comsumer extends  Thread{
    //对果盘的引用
    private FruitePlate fruitePlate;
    public  Comsumer(FruitePlate fruitePlate){
        this.fruitePlate=fruitePlate;
    }
    @Override
    public void run() {
        //开始进行具体的生产方法
        while(true){
            fruitePlate.comsume();
            try {
                if(Thread.currentThread().getName().equals("pool-1-thread-4")){
                sleep(200);}
                else{
                    sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
