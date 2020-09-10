package com.zc.week10;/*
 *@Author:SaveAndTakeDEmo
 *@CreateTime:2020-05-19-59
 */
import java.util.concurrent.TimeUnit;
public class SaveOrTakeDemo {
    public static void main(String[] args) {
        Account account=new Account();
        Thread accountant=new Thread(account,"会计");
        Thread cashier=new Thread(account,"出纳员");

        accountant.start();
        cashier.start();

    }
}
class  Account implements Runnable {
    double left = 0;//账户余额
    public synchronized void count(double sum) throws InterruptedException {

        if (Thread.currentThread().getName().equals("会计")) {
            while (true) {
                left = left + 100;//存钱100万
                sum = sum - 100;//会计还有存多少
                System.out.println("会计这次存钱100万，还要存" + sum + "万"+"账户余额:"+left);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);//喝茶三分钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(left>=50){notifyAll();}
                if (sum == 0) {
                    System.out.println("已经存了300万");
                    break;
                }
            }
        } else if (Thread.currentThread().getName().equals("出纳员")) {
            while (true) {
                if (left < 50 && sum > 0) {
                    System.out.println("余额不足 出纳员无法取钱 请稍等");
                    wait();}
                if (left >=50 && sum > 0) {
                    left = left - 50;//出纳员 取钱50万
                    sum = sum - 50;//出纳员还要取多少
                    System.out.println("出纳员这次取了50万,还要取" + sum + "万"+"账户余额"+left);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);//出纳员喝茶3分钟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                 if ( sum == 0) {
                    System.out.println("已经取了150万");
                    break;
                }
            }
        }

    }
    @Override
    public  void run() {
        if (Thread.currentThread().getName().equals("会计")) {
            try {
                count(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
else if (Thread.currentThread().getName().equals("出纳员")) {
            try {
                count(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}