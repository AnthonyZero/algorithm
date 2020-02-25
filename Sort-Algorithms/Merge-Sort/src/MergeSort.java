import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 * 时间复杂度O(n*logn)  最好O(n*logn) 最坏O(n*logn)
 * 空间复杂度O(n)
 *
 * 分治思想：将已有序的两个子序列（子序列继续递归归并排序）合并，得到完全有序的序列
 *
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {

    //归并排序 对数组区间[start,end]排序
    public void sort(int[] arr, int start, int end) {
        //递归结束条件 当只有一个元素的时候
        if(start == end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(arr, start, mid); //对左侧子序列进行归并排序[start,mid]
        sort(arr, mid + 1, end);  //对右侧子序列进行归并排序[mid+1, end]
        merge(arr, start, mid, end); //合并左右子序列
    }


    //重点 将两个排好序的子序列[left,mid] [mid+1,right]合并为一个序列
    // 结果就是让原始数组[left,right]这段区间有序
    public void merge(int [] arr, int left, int mid, int right){
        int[] aux = Arrays.copyOf(arr, arr.length); //临时数组

        //3个指针 k指向原始数组 用于修改
        int k = left;
        int i = left, j = mid + 1; //两个子序列数组从最左边开始
        //比较这两个子序列当前索引的值，哪个小，就往数组上放
        while(i <= mid && j <= right) {

            //谁比较小，谁就先被放入元素数组中, 移动指针，继续比较下一个
            if(aux[i] < aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }

        //此时还可能存在一个子数组左边序列还有剩余元素
        while(i <= mid) {
            arr[k++] = aux[i++];
        }
        //同上 右序列有剩余
        while(j <= right) {
            arr[k++] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 1, 34, 23, 12, 56, 33, 4, 6, 7, 13, 43, 66, 22, 3};
        new MergeSort().sort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        Random random = new Random();
        int size = 100000;
        int[] array = new int[size]; //10W个随机数
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        new MergeSort().sort(array,0, array.length - 1);
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
