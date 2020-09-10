package com.zc.week10;/*
 *@Author:SaleTicketDemo
 *@CreateTime:2020-05-10-52
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        Thread Zhang,Li,Chen;//三人买票
        TicketHall ticket=new TicketHall();
       Zhang=new Thread(() -> ticket.saleRule(20));
        Zhang.setName("张三");
        Li=new Thread(() -> ticket.saleRule(5));
        Li.setName("李四");
        Chen=new Thread(() -> ticket.saleRule(10));
        Chen.setName("陈皮");
        Chen.start();
        Zhang.start();
        Li.start();

    }
}
//卖票大厅
class TicketHall{
  int five￥=1,ten￥=0,twenty￥=0;//售票员的零钱的数目
    public synchronized void saleRule(float money) {
        String name=Thread.currentThread().getName();
        //1.按三人的买票金额 判断买票顺序
        if(money==5){
            System.out.println(name+"的金额5元,可以买票");
            five￥++;//售票员5元的金额数加1
        }
        else if(money==10){
            if(five￥>=1){
                System.out.println(name+"的金额10元,可以买票");
                ten￥++;
                five￥--;
            }else{
                System.out.println(name+"的金额10元，没有零钱,进入排队");
                try {
                    wait();
                    System.out.println(name+"继续买票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(money==20){
            if(five￥>=1&&ten￥>=1){
                System.out.println(name+"的金额为20元,可以买票了");
                five￥--;
                ten￥--;
                twenty￥++;
            }
            else if(five￥>=3&&ten￥<1){
                System.out.println(name+"的金额为20元,可以买票了");
                five￥=five￥-3;
                twenty￥++;
            }
            else if(five￥<3&&ten￥<1){
                System.out.println(name+"的金额20元，没有零钱,进入排队");
                try {
                    wait();
                    System.out.println(name+"继续买票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        notifyAll();
    }
}
