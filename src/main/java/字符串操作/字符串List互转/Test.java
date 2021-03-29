package 字符串操作.字符串List互转;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    private List<String> mList;
    private String mString;

    public static void main(String [] arg0)
    {
        Test test = new Test();
        test.List2String();
        test.String2List();
        test.Test();
    }


    private void List2String()
    {
        mList = new ArrayList<String>();
        mList.add("Yang XiaoJian");
        mList.add("Yang JiaJia");
        mList.add("Sun YingYin");

        mString = String.join(",",mList);     //String.join   JDK8引入
        System.out.println(mString);

        mString = StringUtils.join(mList,",");  //Apache Commons Lang
        System.out.println(mString);

    }

    private void String2List()
    {
        mString = "Yang XiaoJian,Yang JiaJia,Sun YingYin";
        mList = Arrays.asList(mString.split(","));
        for(String str : mList)
        {
            System.out.println(str);
        }

    }

    private void Test()
    {
        /**
         * asList产生的集合元素是直接引用作为参数的数组，所以当外部数组或集合改变时，数组和集合会同步变化
         * 源码： private static class ArrayList<E> extends AbstractList<E> implements RandomAccess, Serializable {
         *         private static final long serialVersionUID = -2764017481108945198L;
         *         private final E[] a;
         *
         *         ArrayList(E[] array) {
         *             this.a = (Object[])Objects.requireNonNull(array);
         *             //Arrays.ArrayList将外部数组的引用直接通过“=”赋予内部的泛型数组，所以本质指向同一个数组。
         *         }......
         *         }
         */
        String[] arr = {"Yang JiaJia","Yang XiaoJian","Sun YingYin"};
        List list0 = Arrays.asList(arr);
        list0.set(2,"孙荧吟");
        arr[1]="Love";
        System.out.println(list0.toString());

        /**
         * 报错，Arrays.asList返回类型为Arrays$ArrayList,无add,remove方法
         * 不是java.util.ArrayList，而是java.utils.Arrays.ArrayList
         * 源码：     public static <T> List<T> asList(T... a) {
         *              return new Arrays.ArrayList(a);
         *          }
         */
        //list0.add("123");

        /**
         * 由于Arrays.ArrayList参数为可变长泛型，而基本类型是无法泛型化的，
         * 所以它把int[] a数组当成了一个泛型对象，所以集合中最终只有一个元素a
         * 其值为a对象的内存地址
         */
        int[] a = {1,2,5,4};
        List list1 = Arrays.asList(a);
        System.out.println(list1.toString());
        System.out.println(a.hashCode()+"  "+System.identityHashCode(a));

    }


}
