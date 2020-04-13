/*
 * Author: Andliage Pox
 * Date: 2020-01-27
 */

package leetcode.solution;

import java.util.Arrays;

public class Solution00031 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1};
        new Solution00031().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        /*
         * 这个写的就挺优雅的了，虽然还出现了一些小问题，不过问题不大
         * 这个题很有趣，首先思考如何找下一个序列
         * 当一个数组整个是逆序的时候，它就没有下一个序列，需要把它反转成第一个序列
         * 那么当末尾一部分是逆序的时候，我们只需要把这部分的前一位和刚好比它大的数字交换
         * 然后在反转末尾这一部分就是下一个序列
         * 有些难理解，但是画个数组试试就很通俗易懂了
         */
        if (nums == null || nums.length < 2) {
            return;
        }
        int reverseStart = nums.length - 1;
        int changeTarget = nums.length - 1;

        /* 找开始反转的索引，即从末尾逆序结束的地方 */
        while (reverseStart > 0 && nums[reverseStart] <= nums[reverseStart - 1]) {
            reverseStart--;
        }

        /* 为0整个反转，不为0找个数和反转区前一位换 */
        if (reverseStart != 0) {
            while (changeTarget > reverseStart && nums[changeTarget] <= nums[reverseStart - 1]) {
                changeTarget--;
            }
            swap(nums, changeTarget, reverseStart - 1);
        }
        reverse(nums, reverseStart, nums.length - 1);
        /* 时间O(n)空间O(1) */
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
