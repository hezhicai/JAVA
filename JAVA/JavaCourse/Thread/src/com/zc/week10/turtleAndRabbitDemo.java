package com.zc.week10;/*
 *@Author:
 *@CreateTime:2020-05-09-38
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class turtleAndRabbitDemo {
    public static void main(String[] args) {
        RaceWindow raceWindow = new RaceWindow();
    }


}
class RaceWindow extends JFrame implements  Runnable {
    JPanel racePanel;//赛跑面板
    JLabel rabbitLabel,turtleLabel,finishLabel;//乌龟和兔子
    JButton startBtn;//比赛开始按钮
    Thread rabbit,turtle;//兔子 乌龟线程
    RaceWindow(){
        init();
        setVisible(true);//可见
        setTitle("龟兔赛跑");//设置标题
        setBounds(0,0,2000,2000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭时 释放资源
    }

    void init(){
        racePanel=new JPanel();
        racePanel.setLayout(null);//空布局 直接布局定位
        rabbitLabel=new JLabel( new ImageIcon("image/rabbit.jpeg")) ;
        rabbitLabel.setBounds(0,150,200,200);
        turtleLabel=new JLabel(new ImageIcon("image/turtle .jpg"));
        turtleLabel.setBounds(0,650,200,200);
        finishLabel=new JLabel();//终点线
        finishLabel.setBounds(1600,10,10,980);
        finishLabel.setOpaque(true);//组件不透明，默认透明
        finishLabel.setBackground(Color.red);//设置该组件的背景颜色
        startBtn=new JButton("比赛开始");
        startBtn.setBounds(1650,450,200,100);
        add(racePanel);//添加面板
        racePanel.add(rabbitLabel);
        racePanel.add(turtleLabel);
        racePanel.add(finishLabel);
        racePanel.add(startBtn);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(startBtn.getText().equals("比赛开始")) {
                    rabbitLabel.setLocation(0, 150);
                    turtleLabel.setLocation(0, 650);
                    rabbit = new Thread(RaceWindow.this);
                    turtle = new Thread(RaceWindow.this);
                    startBtn.setText("各就位 选手准备 3 2 1 go!");
                }else{
                        rabbit.start();
                        turtle.start();
                        startBtn.setText("比赛开始");
                }
            }
        });


    }

    @Override
    public  void run() {

        if(Thread.currentThread()==rabbit){
            for(int i=0;i<=1600;i+=100){
                if(i==800){//兔子半路要休息
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                rabbitLabel.setLocation(i,150);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
if(Thread.currentThread()==turtle){
    for(int i=0;i<=1600;i+=20){
        turtleLabel.setLocation(i,650);
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    }
}


