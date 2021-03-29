package 文本处理.XML读写;

import java.util.Date;

public class User {
    private String name;
    private String gender;
    private String birthday;
    private String telphone;

    public User(String name , String gender,String birthday, String telphone)
    {
        this.name=name;
        this.gender=gender;
        this.birthday=birthday;
        this.telphone=telphone;
    }

    public String getName()
    {
        return this.name;
    }

    public String getGender()
    {
        return this.gender;
    }

    public String getBirthday()
    {
        return this.birthday;
    }

    public String getTelphone()
    {
        return this.telphone;
    }


}
