package com.zc.ClientToServlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//启动服务器 接收 客户端的连接请求
public class ServerSocketTCP {
    public static void main(String[] args) {
        System.out.println("服务端 接收请求");
        try {
            //1.开启服务器 创建server socket对像  指定端口号
            ServerSocket ss=new ServerSocket(5555);
            //2.调用accept方法 获取socket对象
            Socket accept = ss.accept();
            //3.利用socket对象 得到 输入流
            InputStream is = accept.getInputStream();
            //4.通过输入流接收请求信息
            byte[] bt=new byte[1024];//获取容量单位
            is.read(bt);//存入字节数组里  返回 字符个数
            String msg=new String(bt,0,bt.length);//解析字符数组--》字符串
            System.out.println(msg);//输出信息

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
