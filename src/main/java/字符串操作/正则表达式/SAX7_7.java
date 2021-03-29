package 字符串操作.正则表达式;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAX7_7 {
    public static void main(String args[]){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);
        SAXParser parser = null;
        try {
            parser = spf.newSAXParser();
            Myhandler myhandler = new Myhandler();
            parser.parse(new File("./src/main/java/文本处理/XML读写/Dom.xml"),myhandler);
            for (String str:myhandler.str1) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
