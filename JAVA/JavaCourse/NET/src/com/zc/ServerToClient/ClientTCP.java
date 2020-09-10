package com.zc.ServerToClient;
//客户端 接收服务短的回写信息
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) {

        //1.获取socket对象
        Socket socket= null;
        OutputStream os=null;
        InputStream is=null;
        try {
            socket = new Socket("localhost",6666);
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


        try {
            //1.获取inpustream
            is = socket.getInputStream();
            //2.读取信息
            byte[] bt=new byte[1024];//获取容量单位
             is.read(bt);//存入字节数组里  返回 字符个数
             String msg=new String(bt,0,bt.length);//解析字符数组--》字符串
            System.out.println(msg);//输出信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.关闭socket套接字--联网中断
        try {
            os.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

