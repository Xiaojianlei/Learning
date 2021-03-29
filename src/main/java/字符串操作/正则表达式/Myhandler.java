package 字符串操作.正则表达式;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Myhandler extends DefaultHandler {
    String str1[] = new String[4];
    boolean letter = false;
    int i = 0;
    public void startElement(String uri, String localName, String qName, Attributes atts){
        if(qName.equals("学生姓名")){
            letter = true;
        }
    }
    public void characters(char[] ch,int start,int length){
        String text = new String(ch,start,length);
        if(letter){
            str1[i] = text.trim();
            i++;
            letter = false;
        }
    }
}
