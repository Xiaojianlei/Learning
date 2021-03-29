/**
 * 方法引用 ：Method Reference
 *      ————Lambda表达式支持传递现有的类库函数
 */

package Lambda表达式;


import java.util.Arrays;
import java.util.regex.Matcher;

public class 方法引用 {

    public interface  NumFunction
    {
        double calculate(double num);
    }

    /**
     *  (1) 类::静态方法（Class::staticMethod)，如Math.abs方法
     *          ————等价于提供方法参数的Lambda表达式
     *          ————即Math::abs  ==  x->Math.abs(x)
     */
    private double worker(NumFunction nf,double num)
    {
        return nf.calculate(num);
    }

    public void test1()
    {

        double a=-5.3;
        double b=worker(Math::abs,a);
        double c=worker(Math::floor,a);
        System.out.println("b = "+b+"\nc = "+c);
        NumFunction abs= Math::abs;
        System.out.println(abs.calculate(a));
    }

    /**
     *  (2) Clss::instanceMethod 如String::compareToIgnoreCase
     *          ————第一个参数将变成方法的执行体
     *          ————String::compareToIgnore等价于（x,y)->x.compareToIgnoreCase(y）
     *
     */
    public void test2()
    {
        String[] arr = {"Yang JiaJia","Yang XiaoJian","Sun YingYin"};
        Arrays.sort(arr,(x,y)->x.compareToIgnoreCase(y));
        Arrays.sort(arr,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arr));
    }


    /**
     *  （3）object::instanceMethod,如System.out.println方法
     *      ————等价于提供方法参数的Lambda表达式
     *      ————System.out::println 等价于 x->System.out.println(x)
     *
     */
    public interface voidFunc
    {
        public void exec(String c);
    }
    private void worker(voidFunc vf,String s)
    {
        vf.exec(s);
    }
    public void test3()
    {
        String a="abc";
        worker(System.out::println,a);
    }

    /**
     *  (4) object::instanceMethod,支持this::instanceMethod
     */
    public int lengthCompare(String first,String second)
    {
        return first.length()-second.length();
    }

    public void test4()
    {
        String[] arr = {"Yang JiaJia","Yang XiaoJian","Sun YingYin"};
        Arrays.sort(arr,this::lengthCompare);
        System.out.println(Arrays.toString(arr));
    }


    /**
     *  (5)object::instanceMethod ，支持super::instanceMethod

     */
    public static void main(String[] arg0)
    {
        方法引用 mrf=new 方法引用();
        mrf.test1();
        mrf.test2();
        mrf.test3();
        mrf.test4();
    }
}
