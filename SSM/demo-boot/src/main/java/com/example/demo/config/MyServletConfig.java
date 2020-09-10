package com.example.demo.config;

import com.example.demo.filter.MyFilter;
import com.example.demo.listener.MyListener;
import com.example.demo.servlet.Myservlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServletConfig {

    /**
     * 注册servlet
     */
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new Myservlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);//设置启动顺序
        return registrationBean;
    }

    /**
     * 注册filter
     * @return
     */
@Bean
public FilterRegistrationBean<MyFilter> myFilter(){
    final FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new MyFilter());
    registrationBean.setUrlPatterns(Arrays.asList("/myServlet","/hello"));
    return  registrationBean;
}

    /**
     * 注册 listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

    //配置嵌入式的servlet容器
    @Bean  //一定要将这个定制器加入到容器中
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> embeddedServletContainerCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }

        };
    }
}
