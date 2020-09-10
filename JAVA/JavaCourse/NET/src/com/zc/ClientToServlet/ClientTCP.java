package com.zc.ClientToServlet;
//客户端向服务器端发送连接请求通信
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) {
        System.out.println("客户端 请求连接");
        //1.获取socket对象
        Socket socket= null;
        OutputStream os=null;

        try {
            socket = new Socket("localhost",4000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //2.获取字节输出流
            os = socket.getOutputStream();
            //3.向服务器端发送信息
            os.write("请求连接".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.关闭socket套接字--联网中断  关闭资源
        try {
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

