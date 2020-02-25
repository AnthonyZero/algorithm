import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度O(n*n)  最好O(n*n) 最坏O(n*n)
 * 空间复杂度O(1)
 *
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {

    //从小到大
    public void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        //每次循环都把最小值放在前面
        for(int i = 0; i < arr.length - 1; i++) {
            //寻找[i,n)区间里的最小值 把它放在第i个位置
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                //最小值所在索引更新
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //找到了最小值 就交换位置
            if(i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 1, 34, 23, 12, 56, 33, 4, 6, 7, 13, 43, 66, 22, 3};
        new SelectionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
