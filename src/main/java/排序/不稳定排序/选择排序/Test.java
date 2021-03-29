package 排序.不稳定排序.选择排序;
/**     不稳定排序    **/
public class Test {
    public int[] sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min_index=i;
            for (int j = i; j < array.length; j++) {
                if(array[j]<array[min_index]) min_index=j;
            }
            swap(array,i,min_index);
        }
        return array;
    }

    private void swap(int[] array ,int i,int j){
        int tmp = array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,4,3,3,2,2,3,-1,1};
        new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
}
