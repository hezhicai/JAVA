/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.week11ProducerConsumer.waitNotify;/*
 *@Author:
 *@CreateTime:2020-05-00-24
 *@description:共享资源果盘
 */

public class FruitePlate extends com.zc.week11ProducerConsumer.awaitSignal.FruitePlate {
    int appleNum;
    int orangeNum;
    //放水果
    public synchronized void produce() {
        if (appleNum + orangeNum < 4) {
            if (Thread.currentThread().getName().equals("爸爸")) {
                orangeNum++;
                System.out.println("爸爸放橘子-->现有:" +appleNum+"个苹果！"+ orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                notify();
            } else if (Thread.currentThread().getName().equals("妈妈")) {
                appleNum++;
                System.out.println("妈妈放苹果-->现有:" + appleNum + "个苹果!" +orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                notify();
            }

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //拿水果
    public synchronized void comsume() {
        if (appleNum + orangeNum > 0) {
            if (appleNum > 0) {
                if (Thread.currentThread().getName().equals("女儿")) {
                    appleNum--;
                    System.out.println("女儿拿走苹果-->剩余:" + appleNum + "个苹果!"+orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                    notify();
                }
            } else if (orangeNum > 0) {
                if (Thread.currentThread().getName().equals("儿子")) {
                    orangeNum--;
                    System.out.println("儿子拿走橘子-->剩余:" + appleNum + "个苹果!"+orangeNum + "个橘子!" + "--果盘水果数:" + (appleNum + orangeNum));
                    notify();
                }
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
