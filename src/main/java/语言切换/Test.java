package 语言切换;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String arg [])
    {
        Locale myLocale=Locale.getDefault();    //  获得系统默认的国家\语言环境
        ResourceBundle boundle =ResourceBundle.getBundle("语言切换.res",myLocale);   //  国家\语言环境加载资源文件
        System.out.println(boundle.getString("name"));                   //从对应资源文件获取相应值

        myLocale=new Locale("en","US");  //  获得系统默认的国家\语言环境
        boundle =ResourceBundle.getBundle("语言切换.res",myLocale);   //  国家\语言环境加载资源文件
        System.out.println(boundle.getString("name"));

    }
}

