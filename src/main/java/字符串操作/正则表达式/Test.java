package 字符串操作.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    private static final String REGEX="a*b";
    private static final String INPUT="aaaab";

    public static void main(String arg0[])
    {
        Pattern pattern= Pattern.compile(REGEX);
        Matcher matcher=pattern.matcher(INPUT);

        while (matcher.find())      //查找
        {
            System.out.println("start:"+matcher.start()+"\tend:"+matcher.end());
        }

        System.out.println(matcher.lookingAt());    //部分匹配，从首字符开始判断
        System.out.println(matcher.matches());      //完全匹配

    }


}
