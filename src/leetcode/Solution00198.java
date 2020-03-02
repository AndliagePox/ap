/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode;

public class Solution00198 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution00198().rob(nums));
    }

    public int rob(int[] nums) {
        /*
         * 我一反思就是个动态规划，且公式浅显易懂
         * dp[i]表示到第i家最多能偷到多少
         */
        int n = nums.length;
        int[] dp = new int[n];

        if (n < 1) return 0;
        if (n < 2) return nums[0];
        if (n < 3) return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
        }

        return Math.max(dp[n - 1], dp[n - 2]);
        /* 时间O(n) 空间O(1) */
    }
}
