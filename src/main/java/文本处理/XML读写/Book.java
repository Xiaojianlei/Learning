package 文本处理.XML读写;

import java.util.List;

public class Book {
    private String 标题;
    private String 语言;
    private List<String> 作者;
    private String 出版日期;
    private String 价格;

    public Book(String title , String language,List<String> author, String date,float price)
    {
        this.标题=title;
        this.语言=language;
        this.作者=author;
        this.出版日期=date;
        this.价格=price+"";
    }

    public String getTitle()
    {
        return this.标题;
    }

    public String getLanguage()
    {
        return this.语言;
    }

    public List<String> getAuthor()
    {
        return this.作者;
    }

    public String getDate()
    {
        return this.出版日期;
    }
    public String getPrice()
    {
        return this.价格;
    }


}
