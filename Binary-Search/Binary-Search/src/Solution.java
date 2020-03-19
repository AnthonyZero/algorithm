/// 704. Binary Search
/// https://leetcode-cn.com/problems/binary-search/
/// 时间复杂度: O(logN)
/// 空间复杂度: O(1)
public class Solution {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2; //防止left + right溢出（超出整数范围）
            //middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12,15};
        System.out.println(new Solution().search(nums, 9));
    }

}
