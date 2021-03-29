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

public class DOMTest {
    public static void main(String[] arg0) throws IOException, SAXException, ParserConfigurationException {
        DOMTest test=new DOMTest();
        test.WriteXML();
        test.ReadXML();
    }

    public void ReadBookXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory .newInstance();
        DocumentBuilder builder=factory .newDocumentBuilder();
        Document document=builder.parse(new File( "./src/main/java/文本处理/XML读写/book.xml"));
        Element root=document.getDocumentElement();
        String rooName=root.getNodeName();
        System. out. println("XIL文件根元素的名称为:"+ rooName);
        System. out .println("根元素下的子元素有");
        NodeList children=root. getChildNodes();
        int size=children. getLength();
        for(int i=0;i<size;i++){
            Node node=children.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element elementNode=(Element )node;
                String name=elementNode .getNodeName();
                String content=elementNode.getTextContent();
                System.out.println("<"+name+">" +content+"</"+name+">");
            }
        }
    }



//    public void WriteXMLBook()
//    {
//        List<Book> booksList=new ArrayList<Book>();
//        booksList.add(new Book("如何成为一个程序员","cn",new ));
//
//        try {
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docBuilder= dbFactory.newDocumentBuilder();
//
//            Document doc=docBuilder.newDocument();
//            if(doc!=null)
//            {
//                Element users = doc.createElement("users");
//                for(User u:usersList)
//                {
//                    Element user=doc.createElement("user");
//                    user.setAttribute("gender",u.getGender());
//
//                    Element name=doc.createElement("name");
//                    name.appendChild(doc.createTextNode(u.getName()));
//                    Element birthday=doc.createElement("birthday");
//                    birthday.appendChild(doc.createTextNode(u.getBirthday()));
//                    Element telphone=doc.createElement("telphone");
//                    telphone.appendChild(doc.createTextNode(u.getTelphone()));
//                    user.appendChild(name);
//                    user.appendChild(birthday);
//                    user.appendChild(telphone);
//                    users.appendChild(user);
//                }
//                doc.appendChild(users);
//
//                TransformerFactory transformerFactory = TransformerFactory.newInstance();
//                Transformer transformer=transformerFactory.newTransformer();
//
//                DOMSource domSource=new DOMSource(users);
//
//                File file =new File("./src/main/java/文本处理/XML读写/Dom.xml");
//                StreamResult result=new StreamResult(file);
//
//                transformer.transform(domSource,result);
//
//            }
//
//
//
//        } catch (ParserConfigurationException | TransformerConfigurationException e) {
//            e.printStackTrace();
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        }
//    }

    public void WriteXML()
    {
        List<User> usersList=new ArrayList<User>();
        usersList.add(new User("Yang JiaJia","boy","1999.09.09","18212215795"));
        usersList.add(new User("Sun YingYin","girl","1998.09.12","13567403480"));

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder= dbFactory.newDocumentBuilder();

            Document doc=docBuilder.newDocument();
            if(doc!=null)
            {
                Element users = doc.createElement("users");
                for(User u:usersList)
                {
                    Element user=doc.createElement("user");
                    user.setAttribute("gender",u.getGender());

                    Element name=doc.createElement("name");
                    name.appendChild(doc.createTextNode(u.getName()));
                    Element birthday=doc.createElement("birthday");
                    birthday.appendChild(doc.createTextNode(u.getBirthday()));
                    Element telphone=doc.createElement("telphone");
                    telphone.appendChild(doc.createTextNode(u.getTelphone()));
                    user.appendChild(name);
                    user.appendChild(birthday);
                    user.appendChild(telphone);
                    users.appendChild(user);
                }
                doc.appendChild(users);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer=transformerFactory.newTransformer();

                DOMSource domSource=new DOMSource(users);

                File file =new File("./src/main/java/文本处理/XML读写/Dom.xml");
                StreamResult result=new StreamResult(file);

                transformer.transform(domSource,result);

            }



        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public void ReadXML()
    {
        List<User> usersList=new ArrayList<User>();

        try {
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc =docBuilder.parse("./src/main/java/文本处理/XML读写/Dom.xml");

            Recursion(doc);  //递归遍历

            NodeList user=doc.getElementsByTagName("user"); //通过TagName查找，还可以通过id查找
            for(int i=0;i<user.getLength();i++)
            {
                Node node = user.item(i);
                System.out.println(node.getNodeName()+":"+node.getTextContent()+node.getNodeValue());
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
