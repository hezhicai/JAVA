package spingboot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test01 {
    @RequestMapping("/speak")
    public String speak(){
        return "hello";
    }
    @RequestMapping("/low")
    public void low(){
        System.out.println("low A");
    }


}
