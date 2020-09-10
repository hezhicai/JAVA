package com.zc.week10;/*
 *@Author:
 *@CreateTime:2020-05-23-48
 */

public class StudenTeacherDemo {
    public static void main(String[] args) {
        classroom cls=new classroom();

        cls.teacher.start();
        cls.student.start();
    }
}
class classroom implements  Runnable {
    Thread student, teacher;//声明了两个线程 老师和学生

    public classroom() {//构造器
        student = new Thread(this);
        teacher = new Thread(this);

        teacher.setName("老师");
        student.setName("学生");
    }

    @Override
    public synchronized  void run() {

        if (Thread.currentThread()==teacher) {
            for (int i = 0; i < 3; i++) {
                System.out.println(teacher.getName()+":上课");//老师叫了3次上课
                try {
                    Thread.sleep(1000);//每次间隔1秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            student.interrupt();//学生线程被中断
        }

        //睡觉被叫醒 后 两种情况 1 出去罚站 2 认真听课
        if (Thread.currentThread().getName().equals("学生")) {
            try {
                System.out.println(student.getName()+":开始睡觉咯");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被叫醒" );
            }
           double n= Math.random()*2;
            switch((int) n){
                case 0:
                System.out.println(Thread.currentThread().getName() + ":认真听课");
                break;
                case 1:
                    System.out.println(Thread.currentThread().getName() + ":出去罚站");
                    break;
                default:
                    break;
            }

        }


    }

}
