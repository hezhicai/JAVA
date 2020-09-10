package spingboot.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spingboot.demo.service.HelloService;

/**
 * 注解代替配置文件
 */
@Configuration
public class Myconfig {

    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("使用bean注解给容器中添加组件");
        return new HelloService();


    }
}
