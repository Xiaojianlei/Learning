/**
 * 面向过程程序语言：    参数传递是基本类型的变量
 *
 * 面向对向语言：
 *                      ————————传递基本类型的变量
 *                      ————————传递对象变量
 *
 *传递方法 / 代码块 （函数式程序语言设计）
 *          ————————刚开始,Java为了简单性、一致性，拒绝此功能
 *          ————————为了市场和技术的需要，java8开始，支持此项功能，提出Java的Lambda表达式实现
 */


/**
 * 在计算机编程中，通常用Lambda表示一个匿名函数
 * Lambda表达式可以当作参数，传递给其他高阶函数
 *
 *  ——————类似于匿名方法，一个没有名字的方法
 *  ——————参数，箭头，表达式语句
 *  ——————可以忽略写参数类型
 *  ——————坚决不声明返回值类型
 *  ——————没有public/protected/private/static/final等修饰符
 *  ——————单句表达式，将直接返回值，不用大括号
 *  ——————带return语句，算多句，必须用大括号
 */


package Lambda表达式;

import java.util.Arrays;

public class Lambda {
    public void test()  //实现字符串数组，按长度从小到大排序
    {
        String[] arg0= new String[] {"Yang Jiajia","Sun Yingyin","Yang","Sun"};
        Arrays.sort(arg0, (first, second) -> first.length()-second.length() );
        System.out.println(Arrays.toString(arg0));
    }

    public void test0()     //无参数，仅保留括号，箭头，表达式
    {
        new Thread(
                ()->
                {
                    int sum =0;
                    for(int i=0;i<=100;i++)
                    {
                        sum+=i;
                    }
                    System.out.println("Test 0: 总和:"+sum);
                }
        ).start();
    }
    @FunctionalInterface
    public interface  Adder{//函数式接口只有一个抽象方法

        public int selfAdd(int x);
    }
    public void test1()     //一个参数，可省略括号，箭头，表达式
    {
        Adder c1= x->x++;
        System.out.println(c1);
    }

    /**
     *  ——————如果有返回值，返回值类型会在上下文推断出来，无需声明
     *  ——————只在某几个分支有返回值，这样是不合法的
     */
    public void test2()
    {
        Adder c2=x->{
                    if(x>0) return x;
                    else return -x;
                     };
    }

    public static void main(String[] arg0)
    {
        Lambda test = new Lambda();
        test.test();
        test.test0();
        test.test1();

    }
}
