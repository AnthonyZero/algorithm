import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度O(n*n)  最好O(n) 最坏O(n*n)
 * 空间复杂度O(1)
 *
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 */
public class InsertSort {

    //从小到大排序
    public void sort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        //从第一个元素开始，前面的元素已经排好序了 每次循环完毕 前面的排序数组的大小逐渐增大到最后全部排序完
        for(int i = 1; i < arr.length; i++) {
            //找到前面已排序的结果中第一个比arr[i]小的元素，然后放在它后面
            for(int j = i; j > 0; j--) {
                //当前位置 把当前小的元素慢慢往前面移动 直到找到比他自己要小的元素 就退出当前循环结束，
                if (arr[j] < arr[j - 1]) {
                    //交换位置
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    //插入排序优化 优化前面交换操作所耗时，只找待插入的位置
    public void sortAdvance(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        for(int i = 1; i < arr.length; i++) {

            int temp = arr[i]; //待插入的元素

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            for(; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp; //插入
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 1, 34, 23, 12, 56, 33, 4, 6, 7, 13, 43, 66, 22, 3};
        new InsertSort().sortAdvance(arr);
        System.out.println(Arrays.toString(arr));
    }
}
