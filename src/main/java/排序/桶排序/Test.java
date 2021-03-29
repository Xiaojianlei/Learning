package 排序.桶排序;

import java.util.Arrays;

/**
 * 桶排序
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，将数据划分到不同的桶中
 */
public class Test {
    public int[] sort(int[] array){
        int max=array[0] ,min=array[0];
        for (int i = 0; i < array.length; i++) {
            if(max < array[i]) max=array[i];
            if(min > array[i]) min=array[i];
        }
        return  bucketSort(array ,3, min, max);
    }

    private int[] bucketSort(int[] array,int bucketSize ,int min, int max){
        int bucketCount=( max - min) / bucketSize +1;
        int[][] buckets=new int[bucketCount][0];

        for (int i = 0; i < array.length; i++) {// 利用映射函数将数据分配到各个桶中
            int index= (array[i]-min) /bucketSize;
            buckets[index] = add(buckets[index] ,array[i]);
        }

        int index=0;
        for (int[] bucket :buckets) {//加入结果集
            Arrays.sort(bucket);//桶内排序
            for(int value: bucket) array[index++]=value;
        }
        return array;
    }

    private int[] add(int[] array,int value){//copy on write
        int len = array.length;
        int[] new_array = Arrays.copyOf(array, len + 1);
        new_array[len] = value; // 插入值
        return new_array;
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,20,7,4,3,4,2,5,3,5,7,8,18,20,21,22};
        new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
}
