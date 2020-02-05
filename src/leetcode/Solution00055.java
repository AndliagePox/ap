/*
 * Author: Andliage Pox
 * Date: 2020-02-05
 */

package leetcode;

public class Solution00055 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 1};
        System.out.println(new Solution00055().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        /*
         * 能到达某元素那么它之前的元素一定也能到达
         * 然后没什么了
         */
        int i, maxLocation = 0;
        for (i = 0; i < nums.length; i++) {
            if (maxLocation < i) return false;
            maxLocation = Math.max(maxLocation, nums[i] + i);
            if (maxLocation >= nums.length - 1) return true;
        }
        return true;
        /* 时间O(n) 空间O(1) */
    }
}
