import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度O(n*n)
 * 空间复杂度O(1)
 *
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 */
public class BubbleSort {

    public void sort(int[] array) {
        if (array == null || array.length <= 1){
            return;
        }

        int length = array.length;
        //需要进行length趟比较
        for(int i = 0; i < length - 1; i++) {
            //每进行一次循环把前面大的移动在最后，比如第一次循环最大值放在最后一位，第二次较大值放在了倒数第二位
            //第一次看[0,length-1]，第二次看[0,length-2] 依次慢慢减少
            for(int j = 0; j < length - 1 - i; j++) {
                //开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,33,55,23,7,54,12,78,23,98,22,0,1,24,5,2,56,23,67,88};
        new BubbleSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
