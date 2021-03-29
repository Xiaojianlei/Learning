package 排序.不稳定排序.希尔排序;

/**
 * 希尔排序     不稳定排序
 * 时间复杂度    O(n^（1.3—2）)
 * 空间复杂度    O(1)
 * 是插入排序的一种,本质上是一种分组插入方法,又称“缩小增量排序”（Diminishing Increment Sort），是直接插入排序算法的一种更高效的改进版本
 */
public class Test {
    public int[] sort(int[] array){
        int n = array.length;
        for (int step = n / 2; step >= 1; step /= 2) {
            for (int i = step; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j-step >=0  && array[j-step] > temp) {
                    array[j] = array[j-step];
                    j -= step;
                }
                array[j] = temp;
            }
        }
        return array;
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,4,3,3,2,2,3,-1,1,-4};
        new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
}
