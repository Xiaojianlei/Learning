/**
 * 函数式接口：
 *          ——————是一个接口，符合Java接口的定义
 *          ——————只包含一个抽象方法的接口（可有与Object里面一样的方法,equals、toString等）
 *          ——————可以包括其他的default、static、private方法
 *          ——————由于只有一个未实现的方法，所以Lambda表达式可以自动填上这个未实现的方法
 *          ——————采用Lambda表达式，可以自动创建出一个（伪）嵌套类的对象（没有实际嵌套类
 *          的class文件产生），然后使用，比真正嵌套类更加轻量，更加简洁高效
*/

package Lambda表达式;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class 函数式接口 {
    /**
     * Comparator有两个未实现的方法          ————int compare(T o1, T o2)
     *                                     ————boolean equals(Object obj)
     * 任何实现了Comparator接口的类，肯定继承了Object，也就有equals实现
     */
    @FunctionalInterface //用于编译器检查，是否为函数接口
    public interface  Adder{//函数式接口只有一个抽象方法
        public default  int a(){return 0;}
        public static int b(){return 0; }
        //private int c(){return 0;}

        public boolean equals(Object obj);

        public int selfAdd(int x);
    }


    /**
     * 系统自带的函数接口：
     *      ————涵盖大部分的常用功能，可以重复使用
     *      ————位于java.util.function包中
     *常用的有一下四个：
     *      Boolean Predicate<T>    接收一个参数，返回一个布尔值
     *      void    Consumer<T>     接收一个参数，无返回
     *      R       Function<T,R>   接收一个参数，返回一个值
     *      T       Supplier<T>     数据工厂
      */

    public void Test_Predicate()
    {
        Predicate<Integer> predicate = x->x%2==0;
        System.out.println(predicate.test(6));
    }

    public void Test_Consumer()
    {
        String[] arr = {"Yang JiaJia","Yang XiaoJian","Sun YingYin"};
        List list0 = Arrays.asList(arr);

        Consumer<List> consumer= x->
        {
            for(int i=0;i<x.size();i++)
            {
                System.out.println(x.get(i));
            }
        };

        consumer.accept(list0);
    }

public void Test_Supplier()
{
    Stack<Integer> st =new Stack<Integer>();
    for(int i=0;i<7;i++)
    {
        st.push(i);
    }

    Supplier<Integer> supplier = ()->
    {
        return st.pop();
    };

    System.out.println(supplier.get());
}

public void Test_Function() {
    Function<String, char[]> function = x ->
    {
        return x.toCharArray();
    };
    System.out.println(function.apply("Sun YingYin"));
}


    public static void main(String[] arg0)
    {
        函数式接口 test = new 函数式接口();
        test.Test_Predicate();
        test.Test_Consumer();
        test.Test_Supplier();
        test.Test_Function();
    }

}
