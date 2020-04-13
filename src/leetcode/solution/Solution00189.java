/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode.solution;

import java.util.Arrays;

public class Solution00189 {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution00189().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reserve(nums, 0, nums.length - 1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, nums.length - 1);
    }

    private void reserve(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
        }
    }
}
