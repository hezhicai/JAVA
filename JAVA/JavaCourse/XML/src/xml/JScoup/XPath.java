package xml.JScoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

//   使用Jsoup的Xpath需要额外导入jar包。
//		* 查询w3cshool参考手册，使用xpath的语法完成查
public class XPath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1.获取dom对象
        //1.1获取配置文件的路径
        String path = test01.class.getClassLoader().getResource("test.xml").getPath();
        //1.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document dom = Jsoup.parse(new File(path), "utf-8");
        //2.根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(dom);
        //3.结合xpath语法查询
        //	3.1查询所有user标签
        List<JXNode> jxNodes = jxDocument.selN("//user");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
       //3.2查询user标签下带有type属性的name标签
        System.out.println("-----------------");
        List<JXNode> jxNodes1 = jxDocument.selN("//user/name[@id]");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }
//        3.3查询user标签下带有id属性的name标签 并且id属性值为1
        System.out.println("-----------------");
        List<JXNode> jxNodes2 = jxDocument.selN("//user/name[@id='1']");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
    }
}
