package com.zc.selfTest;/*
 *@Author:
 *@CreateTime:2020-04-09-19
 */
//线程安全的问题

import java.util.concurrent.TimeUnit;

public class Example12_3 {
    private int cont;

    public static void main(String[] args) {
        House house = new House();
        house.setL(100);
        Thread dog = new Thread(house);
        Thread cat = new Thread(house);
        dog.setName("狗");
        cat.setName("猫");
        dog.start();
        cat.start();


    }
}

class House implements Runnable {
    double l;//水量


    public void setL(double l) {
        this.l = l;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        while (l > 0) {
            synchronized (House.class) {//同步代码块解决线程的不安全，单线程进入
                l -= 1;
                System.out.println(Thread.currentThread().getName() + "喝 1 次水" + "剩余的水量:" + l);
            }

            try {

                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
