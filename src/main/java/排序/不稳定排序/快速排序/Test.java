package 排序.不稳定排序.快速排序;
/**     不稳定排序    **/
public class Test {
    private int adjustIndex(int[] array ,int l ,int r){
        int i = l ,j = r , x =array[l];
        while( i < j){
            while (i<j && array[j] >=x) j--;
            if(i<j) array[i++]=array[j];
            while (i<j && array[i]<=x ) i++;
            if(i<j) array[j--]=array[i];
        }
        array[i]=x;
        return i;
    }

    private void quickSort(int[]  array ,int l ,int r){//分治实现
        if(l<r){
            int index =adjustIndex(array, l, r);
            quickSort(array, l, index-1);
            quickSort(array, index+1, r);
        }
    }

    public void sort(int[] array){
        quickSort(array,0,array.length-1);
    }

    //测试入口
    public static void main(String[] args) {
//        int a[]={1,4,3,3,2,2,3,-1,1};
//        new Test().sort(a);
//        for(int i: a) System.out.println(i);
        int h =0b111;
        System.out.println(h  ^ (h >>> 16));
    }


}
