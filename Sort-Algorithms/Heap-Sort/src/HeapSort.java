import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 * 时间复杂度O(n*logn)  最好O(n*logn) 最坏O(n*logn)
 * 空间复杂度O(1)
 *
 *
 * 创建一个最大堆 H[0……n-1]；
 * 把堆首（最大值）和堆尾互换；
 * 把堆的尺寸缩小 1（不考虑步骤2已经放到后面的数据），并调用 shiftDown(0)，目的是把当前堆的最大值调整到第一个位置
 * 重复步骤 2，直到堆的尺寸为 1。此时数组就是从小到大的排列顺序
 */
public class HeapSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //把数组先调整为最大堆
        for(int i = (arr.length - 1) / 2; i >= 0; i --) {
            //只考虑非叶子节点（非叶子节点单独也可看成是堆）就行了，不用从数组最后一个元素开始
            siftDown(arr, arr.length, i);// 小的元素下沉，大的元素往上浮
        }
        //此时第一个元素即是最大值
        for(int n = arr.length - 1; n > 0; n --) {
            swap(arr, 0, n); //当前堆的最大值data[0]移动到后面data[i]
            siftDown(arr, n, 0); //在减少一个元素的情况下 下沉第一个元素，让此时最大值冒上来到data[0]
        }
    }


    /**
     * 指定哪个索引的元素 下沉
     * @param arr 原数组
     * @param n  此时考虑的数组大小（堆大小） n <= 原数组大小
     * @param index  指定的下沉元素索引
     */
    private void siftDown(int[] arr, int n, int index) {
        while (2 * index + 1 < n) {
            // 当左孩子索引没有越界 说明存在左还是 可以下沉
            int maxIndex = 2 * index + 1; //先假定maxIndex是左右孩子较大的元素索引

            //存在右孩子 更新maxIndex
            if (maxIndex + 1 < n && arr[maxIndex + 1] > arr[maxIndex]) {
                //并且右孩子 元素大于左孩子元素 更新maxIndex;
                maxIndex = maxIndex + 1; //此时是右孩子索引
            }

            //比较当前下沉元素 和左右孩子元素较大值 看是否替换
            if (arr[index] >= arr[maxIndex]) {
                break; //大于等于 退出完成 当前节点已经大于左右孩子节点
            }

            //替换
            swap(arr, index, maxIndex);

            //更新index 继续循环
            index = maxIndex;
        }
    }

    //交换元素
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 1, 34, 23, 12, 56, 33, 4, 6, 7, 13, 43, 66, 22, 3};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));

        Random random = new Random();
        int size = 100000;
        int[] array = new int[size]; //10W个随机数
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        new HeapSort().sort(array);
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
