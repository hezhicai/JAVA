package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo01")
public class demo01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//   01设置编码格式-->通知浏览器使用 utf-8进行解码
        response.setContentType("text/html;charset=utf-8");
//        02选择 字符流   printwrite 可自动将缓冲区的内容输出来;response请求后可以自动关闭资源
        PrintWriter writer = response.getWriter();
//        03向 客户端 写数据
        writer.write("生日快乐！！！");


    }
}
