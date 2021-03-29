package 排序.不稳定排序.堆排序;

import java.util.List;

/**     不稳定排序    **/
public class Test {
    public int[] sort(int[] array)
    {
        int n=array.length;
        for (int i = n/2-1; i >=0 ; i--) heapify(array , n ,i);//建堆 , 从最后个父节点往前开始
        for (int i = n-1; i >0 ; i--) {//排序 ,将最大的数（第0位）取出放在最后
            swap(array ,0, i);
            heapify(array ,i ,0);
        }
        return array;
    }

    private void swap(int[] array ,int i,int j){
        int tmp = array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    /**
     * 维护堆的性质
     * @param array 存储堆的数组
     * @param n     未排好序的数组长度
     * @param i     待维护节点的下标
     */
    private void heapify (int[] array , int n ,int i){
        int lson= i*2 + 1; //左孩子
        int rson= i*2 + 2; //右孩子
        int largest = i;
        if(lson < n && array[lson] < array[largest]) largest = lson;
        if(rson < n && array[rson] < array[largest]) largest = rson;
        if(largest != i){
            swap(array, i, largest);
            heapify(array , n , largest);
        }
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,2,1,5,5,2,2,8,7,9};
        new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
    
}
