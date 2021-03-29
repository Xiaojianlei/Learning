package 排序.稳定排序.计数排序;

/**
 * 计数排序
 * 时间复杂度    O(n + k)
 * 空间复杂度    O(k)
 * 当输入的元素是 n 个 0 到 k 之间的整数时。计数排序不是比较排序，排序的速度快于任何比较排序算法。
 * 由于用来计数的数组长度的长度取决于待排序数组中数据的范围,牺牲较大空间换取时间
 * 在实现优化上，可记录数组的最大最小值，以此映射范围
 */
public class Test {
    public int[] sort(int[] array){
        int max=array[0] ,min=array[0];
        for (int i = 0; i < array.length; i++) {
            if(max < array[i]) max=array[i];
            if(min > array[i]) min=array[i];
        }
        return sort(array,min,max);
    }

    private int[] sort(int[] array ,int min ,int max){
        int count[] =new int[max-min+1];
        for (int i = 0; i < array.length; i++)  count[ array[i]-min ]++;
        int index=0;
        for (int i = 0; i < count.length ; i++) {
            while(count[i]-->0) array[index++]=i+min;
        }
        return array;
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,4,3,3,2,-1,2,3,0,0,-4};
        new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
}
