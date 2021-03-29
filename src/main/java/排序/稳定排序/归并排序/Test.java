package 排序.稳定排序.归并排序;

/**
 * 归并排序  稳定排序
 * 时间复杂度 O(n*log n)
 * 空间复杂度 T(n)
 * 采用分治算法，将数组成两部分处理后，将两数组进行归并
 */
public class Test {
    public int[] sort(int[] array){
        return mergeSort(array,0,array.length-1);
    }
    private  int[] mergeSort(int[] nums, int l, int r) { //分治
        if (l == r) return new int[] { nums[l] };

        int mid = (l+r)>>1;   //l + (h - l) / 2 防止溢出;
        int[] left = mergeSort(nums, l, mid); //左有序数组
        int[] right = mergeSort(nums, mid + 1, r); //右有序数组
        return merge(left , right);

    }

    private  int[] merge(int[] nums1,int[] nums2){
        int[] result = new int[nums1.length + nums2.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            result[m++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < nums1.length) result[m++] = nums1[i++];
        while (j < nums2.length) result[m++] = nums2[j++];
        return result;
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,4,3,3,2,2,3,-1,1};
        a=new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
}
