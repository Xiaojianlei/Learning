/**
 *  Stax    (Streaming API for XML)
 *  流模型中的拉模型
 *  在遍历文档时，会把感兴趣的部分从读取器中拉出，不需要引发事件，
 *  允许我们选择性地处理节点。这大大提高了灵活性，以及整体效率。
 *  两套处理API
 *      ----基于指针的API,   XMLStreamReader
 *      ----基于迭代器的API,  XMLEventReader
 */
package 文本处理.XML读写;

import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class StaxTest {

    public static void main(String[] arg0)
    {
        StaxTest staxTest = new StaxTest();
        staxTest.readByStream();
        System.out.println("--------------------------------------");
        staxTest.readByEvent();
    }

    public void readByStream()
    {
        String xmlFile ="./src/main/java/文本处理/XML读写/Dom.xml";
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader streamReader = null;
        try {
            streamReader = factory.createXMLStreamReader(new FileReader(xmlFile));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
                while(true) //基于指针遍历
                {
                    if (!streamReader.hasNext()) break;
                    int event = streamReader.next();
                    if (event == XMLStreamConstants.START_ELEMENT)
                    {//如果是元素的开始
                        if ("name".equals(streamReader.getLocalName()))
                        {
                            System.out.println("name:" + streamReader.getElementText());
                        }
                    }
                }
                streamReader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

    public void readByEvent()
    {
        String xmlFile = "./src/main/java/文本处理/XML读写/Dom.xml";
        XMLInputFactory factory = XMLInputFactory.newInstance();
        boolean nameFlag = false;
        try {
            //创建基于迭代器的事件读取器对象
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(xmlFile));
        while(eventReader.hasNext())//遍历迭代器
        {
            XMLEvent event= eventReader.nextEvent();
            if(event.isStartElement())//如果是元素的开始
            {
                StartElement start = event.asStartElement();
                String name = start.getName().getLocalPart();//获得元素标签的本地名称
                if(name.equals("name"))
                {
                    nameFlag = true;
                    System.out.print("name:");
                }

                //获得所有属性
                Iterator attrs = start.getAttributes();
                while(attrs.hasNext())
                {
                    Attribute attr = (Attribute)attrs.next();
                }
            }

            if(event.isCharacters())//如果是标签间正文
            {
                String s = event.asCharacters().getData().trim();
                if(null != s  &&s.length()>0 && nameFlag)
                {
                    System.out.println(s);
                }
            }

            if(event.isEndElement())//如果是结束标签
            {
                EndElement end = event.asEndElement();
                String name = end.getName().getLocalPart();
                if(name.equals("name"))
                {
                    nameFlag=false;
                }
            }
        }

        eventReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
