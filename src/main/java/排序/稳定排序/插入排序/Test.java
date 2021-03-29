package 排序.稳定排序.插入排序;

/**     稳定排序    **/
public class Test {
    public int[] sort(int[] array)  {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];// 记录要插入的数据
            // 从已经排序的序列最右边的开始往前比较，找到比其小的数
            int j = i;
            while (j-1 >= 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            if (j != i) array[j] = tmp; // 存在比其小的数，插入
        }
        return array;
    }

    public int[] bin_sort(int[] array)  {//折半插入
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];// 记录要插入的数据
            // 从已经排序的序列最右边的开始折半查找，找到第一个比其小或相等的数
            int low=0 ,high=i-1;
            while(low<=high){
                int mid=(low+high)>>1;
                if(tmp < array[mid]) high=mid-1;
                else low=mid+1;
            }
            for(int j = i; j > low; j--) array[j]=array[j-1];//数组后裔
            array[low] = tmp; //插入
        }
        return array;
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,4,3,3,2,2,3};
        new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
}
