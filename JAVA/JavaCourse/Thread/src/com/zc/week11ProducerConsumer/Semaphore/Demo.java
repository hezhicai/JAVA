package com.zc.week11ProducerConsumer.Semaphore;
public class Demo {
    public static void main(String[] args) {
        Plate pl=new Plate();
        for (int i = 0; i < 6; i++) {
            new Thread(pl).start();
        }
    }

}
