/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.week11ProducerConsumer.ThreadPool;/*
 *@Author:zc
 *@CreateTime:2020-05-00-24
 *@description:共享资源果盘
 --Condition能够支持多个等待队列(生产队列 消费队列)
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FruitePlate  extends ReentrantLock {//继承锁
    int appleNum;
    int orangeNum;
    private Condition condition1=newCondition();//爸爸线程状态的控制
    private Condition condition2=newCondition();//妈妈线程状态的控制
    private  Condition condition3=newCondition();//女儿线程状态的控制
    private  Condition condition4=newCondition();//儿子线程状态的控制
    //放水果的方法
    public  void produce() {
            try {
                lock();//给需要同步代码块--->上锁
                    //父亲
                    if (Thread.currentThread().getName().equals("pool-1-thread-1")) {
                        if (appleNum + orangeNum < 4) {
                        orangeNum++;
                        System.out.println("爸爸放橘子-->现有:" +appleNum+"个苹果！"+ orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                        condition4.signal();//通知消费者队列的儿子
                    } else{
                            System.out.println("果盘已满:爸爸不要放橘子");
                            condition1.await();//爸爸进入生产者等待队列
                        }
                    }
                    //母亲
                     if (Thread.currentThread().getName().equals("pool-1-thread-2")) {
                         if (appleNum + orangeNum < 4) {
                        appleNum++;
                        System.out.println("妈妈放苹果-->现有:" + appleNum + "个苹果!" +orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                        condition3.signal();//通知消费者队列的女儿
                    }
                     else{
                         System.out.println("果盘已满:媽媽不要放苹果");
                         condition2.await();//妈妈进入生产者等待队列
                         }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                unlock();//代码执行完成-->手动解锁
            }
    }
    //拿水果
    public  void comsume() {
            try {
                lock();//给需要同步代码块--->上锁
                     //女儿线程
                        if (Thread.currentThread().getName().equals("pool-1-thread-3")) {
                            if (appleNum > 0) {
                            appleNum--;
                            System.out.println("女儿拿走苹果-->剩余:" + appleNum + "个苹果!"+orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                            condition2.signal();//通知妈妈
                        }else {
                                System.out.println("果盘没有苹果,女儿请不要来拿苹果");
                                condition3.await();//女兒进入消费者等待队列
                            }
                    }
                        //儿子线程
                        if (Thread.currentThread().getName().equals("pool-1-thread-4")) {
                            if (orangeNum > 0) {
                            orangeNum--;
                            System.out.println("儿子拿走橘子-->剩余:" + appleNum + "个苹果!"+orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                            condition1.signal();//通知爸爸
                        }else {
                                System.out.println("果盘没有橘子,儿子请不要来拿橘子");
                                condition4.await();//兒子進入消费者等待队列
                            }
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                unlock();//代码执行完成-->手动解锁
            }
        }


}
