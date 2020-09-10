package com.zc.week11ProducerConsumer.Semaphore;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Plate implements Runnable {
    int size = 2;
    Semaphore plate = new Semaphore(size);//同时让size个线程进行  保证资源的互斥
    Date date = new Date();

    @Override
    public void run() {
        try {
            plate.acquire(1);
            size--;
            System.out.println(Thread.currentThread().getName() + ":获得打饭窗口" + "还剩:" + (size) + "空窗口");
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            plate.release(1);
            size++;
            System.out.println(Thread.currentThread().getName() + "打完饭" + "还剩:" + (size) + "空窗口");
            }


    }
    }

