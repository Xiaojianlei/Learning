/**
 *  SAX （Simple API for XML)
 *  采用事件/流模型来解析XML,更快速、更轻量,擅长读。
 *  有选择的解析和访问，不像DOM加载整个文档，内存要求更低。
 *  SAX对XML文档的解析为一次性读取，不创建/不存储文档对象，很难同时访问文档中的多处数据。
 *  推模型。当它每发现一个节点就引发一个事件，而我们需要编写这些事件的处理程序。  关键类：DefaultHandler
 */
package 文本处理.XML读写;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXTest {
    public static void main(String[] arg0) throws SAXException, IOException {
        XMLReader xmlReader= XMLReaderFactory.createXMLReader();
        UserHandler userHandler = new UserHandler();
        xmlReader.setContentHandler(userHandler);
        xmlReader.parse("./src/main/java/文本处理/XML读写/Dom.xml");
        for(User user :userHandler.getNameList())
        {
            System.out.println("name:"+user.getName()+"\ngender:"+user.getGender()+"\nbirthday:"+user.getBirthday()+"\ntelphone:"+user.getTelphone());
        }

    }

}

class UserHandler  extends DefaultHandler {
    private List<User> usersList =new ArrayList<User>();
    private boolean userFlag = false;
    private boolean nameFlag = false;
    private boolean birthdayFlag = false;
    private boolean telphoneFlag = false;
    private String user ;
    private String gender;
    private String name ;
    private String birthday ;
    private String telphone ;
    public List<User> getNameList() {
        return this.usersList;
    }

    @Override
    public void startDocument() throws SAXException {
       System.out.println("Start parse document...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
     switch(qName)
     {
         case "user":
             userFlag=true;
             gender=attributes.getValue("gender");
             break;
         case "name":
             nameFlag=true;
             break;
         case "birthday":
             birthdayFlag = true;
             break;
         case "telphone":
             telphoneFlag = true;
             break;
     }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName)
        {
            case "user":
                userFlag =false;
                break;
            case "name":
                nameFlag=false;
                break;
            case "birthday":
                birthdayFlag=false;
                break;
            case "telphone":
                telphoneFlag = false;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch,start,length);
        if(nameFlag)
        {
            name=str;
        }
        if(birthdayFlag)
        {
            birthday=str;
        }
        if(telphoneFlag)
        {
            telphone=str;
            this.usersList.add(new User(name,gender,birthday,telphone));
        }
    }
}