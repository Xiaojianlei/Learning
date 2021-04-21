package 排序.稳定排序.归并排序;

import java.util.Arrays;

public class 原地归并 {
    private static void mergeSort(int[] nums,int[] temp , int l, int r) { //分治
        if (l == r) return;
        int mid = (l+r)>>1;   //l + (h - l) / 2 防止溢出;
        mergeSort(nums,temp, l, mid); //左有序数组
        mergeSort(nums,temp, mid + 1, r); //右有序数组
        merge(nums ,temp,l ,mid ,mid+1 , r);
    }

    private static void merge(int[] nums,int[] temp , int lstart ,int lend ,int rstart , int rend){
        for (int i = rstart; i <=rend ; i++) {
            temp[i] = nums[i];
        }
        int last = rend , i =lend , j=rend;
        while (i>=lstart && j>=rstart){
            nums[last--] = nums[i] >= temp[j] ? nums[i--] : temp[j--];
        }
        while (j>=rstart) nums[last--] = temp[j--];
    }

    public static void main(String[] args) {
        int a[]={1,4,3,3,2,2,3,-1,1,7,-2};
        int[] b=new int[a.length];
        mergeSort(a ,b,0,a.length-1);
        for(int i: a) System.out.println(i);
    }

//    private static int test(int... bolls ){
//        int positive = 0 ,result = 0;
//        for(int boll : bolls){
//            if(boll > 0) positive++;
//            else  result+=positive;
//        }
//        return result;
//    }

//    public static void main(String[] args) {
//        System.out.println(test(2, 3, -4,-5));
//    }

    // 1 2 3 4 | 1 1 2 2
    //1 2 3 | 2 1 1 2 4
    //1 2 | 2 2 1 1| 3 4
    //1 | 1 2 2 1 1 | 2 3 4
//    private  int[] merge(int[] nums1,int[] nums2){
//        int[] result = new int[nums1.length + nums2.length]; //新有序数组
//
//        int m = 0, i = 0, j = 0;
//        while (i < nums1.length && j < nums2.length) {
//            result[m++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
//        }
//        while (i < nums1.length) result[m++] = nums1[i++];
//        while (j < nums2.length) result[m++] = nums2[j++];
//        return result;
//    }
}
