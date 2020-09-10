package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class testFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request消息进行增强
        System.out.println("拦截");
        //放行 准备请求资源中-->跳转到jsp页面中
        chain.doFilter(req, resp);
        //对response对象的消息做了增强
        System.out.println("释放");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化");
    }

    public void destroy() {
        System.out.println("摧毁");
    }


}
