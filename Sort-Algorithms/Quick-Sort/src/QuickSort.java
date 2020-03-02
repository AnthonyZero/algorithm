import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * 时间复杂度O(n*logn)  最好O(n*logn) 最坏O(n*n) 基准每次都是最左边递归树退化为链表
 * 空间复杂度O(logn) 在递归过程中产生的栈空间大小
 *
 *
 * 从数列中挑出一个元素，称为 “基准”（pivot）
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地把小于基准值元素的子数列和大于基准值元素的子数列进行快速排序；
 */
public class QuickSort {

    //对数组arr[left,right] 进行快速排序
    public void sort(int[] arr, int left, int right) {
        //递归结束条件 只有一个元素
        if(left >= right) {
            return;
        }
        int partitionIndex = partition(arr, left, right);
        sort(arr, left, partitionIndex - 1); //基准元素就不参与了 已经界限了
        sort(arr, partitionIndex + 1, right);
    }

    /**
     * 分区操作 返回基准所在位置[left,right]
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right){
        int pivot = left; //设定基准值 默认左边第一位
        int index = pivot + 1; //从index开始占位，比基准小的移动到这开始的后面
        for(int i = index; i <= right; i++) {
            if(arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        //交换基准的位置，此时基准前面的元素都小于它，后面的都大于它
        swap(arr, index - 1, pivot);
        return index - 1;
    }

    //交换元素
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 1, 34, 23, 12, 56, 33, 4, 6, 7, 13, 43, 66, 22, 3};
        new QuickSort().sort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        Random random = new Random();
        int size = 100000;
        int[] array = new int[size]; //10W个随机数
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        new QuickSort().sort(array,0, array.length - 1);
        //判断是否是排序正确的
        boolean success = true;
        for(int i = 0; i < size - 1; i ++) {
            if (array[i + 1] < array[i]) {
                success = false;
                break;
            }
        }
        System.out.println(success);
    }
}
