package xml.JScoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。
// 它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
public class test01 {
// 步骤：
//				1. 导入jar包
//				2. 获取Document对象
//				3. 获取对应的标签Element对象
//				4. 获取数据
    public static void main(String[] args) throws IOException {
        //1.获取dom对象
        //1.1获取配置文件的路径
        String path=test01.class.getClassLoader().getResource("test.xml").getPath();
        //1.2解析xml文档，加载文档进内存，获取dom树--->Document
         Document dom=Jsoup.parse(new File(path),"utf-8");

        //2.获取元素对象Elements---获取标签名为 user的对象
        Elements user=dom.getElementsByTag("user");
        System.out.println(user);
        //3.获取属性名为 id的元素对象
        System.out.println("-----------------------");
        Elements id = dom.getElementsByAttribute("id");
        System.out.println(id);
        //4.获取属性值为 value的元素对象
        System.out.println("--------------------");
        Elements value = dom.getElementsByAttributeValue("type", "value");
        System.out.println(value);
        //5.获取id属性值元素对象
        System.out.println("--------------------");
        Element elementById = dom.getElementById("1");
        System.out.println(elementById);
      //6.获取文本
        System.out.println("------获取文本----------");
        String text = user.text();
        System.out.println(text);
       //----------------
        System.out.println("-------------网址源码");
        URL url=new URL("https://www.bilibili.com/video/BV1uJ411k7wy?p=673");
        Document dom2=Jsoup.parse(url,10000);
        Elements div = dom2.getElementsByTag("div");
        System.out.println(div);
    }
}
