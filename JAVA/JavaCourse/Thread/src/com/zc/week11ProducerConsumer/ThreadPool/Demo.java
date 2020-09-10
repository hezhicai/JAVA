/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.week11ProducerConsumer.ThreadPool;/*
 *@Author:
 *@CreateTime:2020-05-00-25
 *@description:
 默认的线程池他的名字 也是默认的！！！
 pool-1-thread-1     一次类推  ；；；
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        //资源需要实例化
        FruitePlate fruitePlate=new FruitePlate();
        //线程池创建四个线程
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        executorService.execute(new Producer(fruitePlate));//pool-1-thread-1
        executorService.execute(new Producer(fruitePlate));//pool-1-thread-2
        executorService.execute(new Comsumer(fruitePlate));//pool-1-thread-3
        executorService.execute(new Comsumer(fruitePlate));//pool-1-thread-4
        executorService.shutdown();//线程任务完成后关闭

    }
}
