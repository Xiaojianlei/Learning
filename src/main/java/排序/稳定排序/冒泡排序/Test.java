package 排序.稳定排序.冒泡排序;
/**     稳定排序    **/
public class Test {
    public int[] sort(int array[]) {
        for(int i =1 ; i<array.length ; i++) {
            for(int j=0 ; j<array.length-i ; j++) {
                if(array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    //测试入口
    public static void main(String[] args) {
        int a[]={1,4,3,3,2,2,3,-1,1};
        new Test().sort(a);
        for(int i: a) System.out.println(i);
    }
}
