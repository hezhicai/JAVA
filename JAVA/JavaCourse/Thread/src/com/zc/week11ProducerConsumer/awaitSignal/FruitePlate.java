/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.week11ProducerConsumer.awaitSignal;/*
 *@Author:zc
 *@CreateTime:2020-05-00-24
 *@description:共享资源果盘
 --Condition能够支持多个等待队列(生产队列 消费队列)
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class FruitePlate  extends ReentrantLock {
    int appleNum;
    int orangeNum;
    private Condition plateCondition=newCondition();//盘子监视器 与锁关联
    private Condition appleCondition=newCondition();//apple监视器
    private  Condition orangeConditio=newCondition();//orange监视器
    //放水果的方法
    public  void produce() {
            try {
                lock();//给需要同步代码块--->上锁
                    //父亲
                    if ("爸爸".equals(Thread.currentThread().getName())) {
                        if (appleNum + orangeNum < 4) {
                        orangeNum++;
                        System.out.println("爸爸放橘子-->现有:" +appleNum+"个苹果！"+ orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                            orangeConditio.signal();//橘子队列的儿子
                    } else{
                            System.out.println("果盘已满:爸爸不要放橘子");
                            plateCondition.await();//爸爸进入生产者等待队列
                        }
                    }
                    //母亲
                     if ("妈妈".equals(Thread.currentThread().getName())) {
                         if (appleNum + orangeNum < 4) {
                        appleNum++;
                        System.out.println("妈妈放苹果-->现有:" + appleNum + "个苹果!" +orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                             appleCondition.signal();//通知消费者队列的女儿
                    }
                     else{
                         System.out.println("果盘已满:媽媽不要放苹果");
                             plateCondition.await();//妈妈进入生产者等待队列
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
                        if ("女儿".equals(Thread.currentThread().getName())) {
                            if (appleNum > 0) {
                            appleNum--;
                            System.out.println("女儿拿走苹果-->剩余:" + appleNum + "个苹果!"+orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                                plateCondition.signalAll();//通知盘子有空位
                        }else {
                                System.out.println("果盘没有苹果,女儿请不要来拿苹果");
                                appleCondition.await();//女兒进入消费者等待队列
                            }
                    }
                        //儿子线程
                        if ("儿子".equals(Thread.currentThread().getName())) {
                            if (orangeNum > 0) {
                            orangeNum--;
                            System.out.println("儿子拿走橘子-->剩余:" + appleNum + "个苹果!"+orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                                plateCondition.signalAll();//通知爸爸 妈妈来放
                        }else {
                                System.out.println("果盘没有橘子,儿子请不要来拿橘子");
                                orangeConditio.await();//兒子進入消费者等待队列
                            }
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                unlock();//代码执行完成-->手动解锁
            }
        }


}
