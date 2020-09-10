package web.Servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet("/demo1")
public class Servletdemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet对象创建完成");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我是Servlet服务");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {
        System.out.println("Servlet对象销毁完成");
    }
}
