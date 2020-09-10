package com.example.demo.config;
import com.example.demo.component.MyHandleLogin;
import com.example.demo.component.MyLocaleResolver;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                //讲main.html页面 映射到 dashboard.html页面
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot2.0以上  没做好静态资源映射  需要排除
                registry.addInterceptor(new MyHandleLogin()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
            }
        };
        return adapter;
    }
/**
 * 添加区域解析器的 组件
 */
@Bean
    public MyLocaleResolver localeResolver(){
    return new MyLocaleResolver();
}

}
