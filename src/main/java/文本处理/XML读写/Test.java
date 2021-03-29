/**
 * DOM (Document Object Model) 文档对象模型
 * 树结构，全部加载进内存
 * 擅长小规模 读/写
 */

package 文本处理.XML读写;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] arg0)
    {
        Test test=new Test();
        System.out.println("____________________");
        test.ReadXML();
    }

    public void ReadXML()
    {
        try {
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc =docBuilder.parse("E:/IDEA_Project/XML/Test2/test.xml");

            Recursion(doc);  //递归遍历
System.out.println("++++++++"+doc.getTextContent());
            NodeList user=doc.getElementsByTagName("ARTICLE"); //通过TagName查找，还可以通过id查找
            for(int i=0;i<user.getLength();i++)
            {
                Node node = user.item(i);
                System.out.println(node.getNodeName()+":"+node.getTextContent()+node.getAttributes().getNamedItem("EDITOR").getTextContent());
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Recursion(Node node)       //递归遍历节点
    {
        NodeList nodeList = node.getChildNodes();
        for(int i=0;i<nodeList.getLength();i++)
        {
            Node n=nodeList.item(i);
            System.out.println(n.getNodeName()+" "+n.getTextContent()+"  "+n.getChildNodes().getLength());
            Recursion(n);
        }
    }

}
