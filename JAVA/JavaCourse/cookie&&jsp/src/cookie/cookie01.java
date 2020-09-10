package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie01")
public class cookie01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//         创建cookie对象
        Cookie cookie01=new Cookie("hzc","何智才");
//        Cookie cookie02=new Cookie("何智领","hezhiling");//name不能为中文
//        设置cookie存活时间
//        cookie01.setMaxAge(30);//30秒
//        cookie02.setMaxAge(0);//删除cookie
//        在服务端绑定cookie对象
        response.addCookie(cookie01);
//        response.addCookie(cookie02);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
