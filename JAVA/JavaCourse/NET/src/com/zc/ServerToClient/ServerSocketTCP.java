package com.zc.ServerToClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//启动服务器 向 客户端 回写数据
public class ServerSocketTCP {
    public static void main(String[] args) {


        Socket accept=null;
        OutputStream os=null;
        InputStream is=null;
        try {
            //1.开启服务器 创建server socket对像  指定端口号
            ServerSocket ss=new ServerSocket(6666);
            //2.调用accept方法 获取socket对象
            accept = ss.accept();
            //3.利用socket对象 得到 输入流
          is = accept.getInputStream();
            //4.通过输入流接收请求信息
            byte[] bt=new byte[1024];//获取容量单位
            is.read(bt);//存入字节数组里  返回 字符个数
            String msg=new String(bt,0,bt.length);//解析字符数组--》字符串
            System.out.println(msg);//输出信息

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            //1。获取output对象
            os= accept.getOutputStream();
            //2.回写信息
            os.write("收到连接 马上就绪".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
      //关资源 套接字
        try {
            is.close();
            os.close();
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
