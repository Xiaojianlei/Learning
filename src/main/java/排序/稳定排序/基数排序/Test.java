package 排序.稳定排序.基数排序;
/**
 * 基数排序 稳定排序
 * 时间复杂度    O(nd）
 * 空间复杂度    O(n+k)
 * 将数从个位开始，每次将其分到该位数的桶里，即在保证低位有序的情况下排序下一位
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public int[] sort(int[] array) {
        return sort(array, 4);
    }

    private int[] sort(int[] array, int d) {
        int base = 1;
        for (int i = 0; i < d; i++) {
            int[][] buckets = new int[10][0]; //数组的第一维表示可能的余数0-9
            for (int j = 0; j < array.length; j++) {
                int index = (array[j] / base) % 10;
                buckets[index] = add(buckets[index], array[j]);
            }

            int index = 0;
            for (int[] bucket : buckets) {
                for (int value : bucket) {
                    array[index++] = value;
                }
            }
            base *= 10;
        }
        return array;
    }

    private int[] add(int[] array, int value) {//copy on write
        int len = array.length;
        int[] new_array = Arrays.copyOf(array, len + 1);
        new_array[len] = value;
        return new_array;
    }

    private int[] sort_1(int[] number, int d) {
        int k = 0;
        int n = 1; //基数，1 10 100
        int m = 1; //控制键值排序依据在哪一位,个位、十位、百位....
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组order[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) number[k++] = temp[i][j];
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
        return number;
    }

    //测试入口
    public static void main(String[] args) {
        int a[] = {732, 22, 8848, 93, 43, 199, 9999, 55, 142, 28, 65, 39, 81, 10, 33, 100};
        new Test().sort(a);
        for (int i : a) System.out.println(i);
    }
}
