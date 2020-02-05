/*
 * Author: Andliage Pox
 * Date: 2020-02-05
 */

package leetcode;

public class Solution00045 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 4, 3, 2, 1};
        System.out.println(new Solution00045().jump(nums));
    }

    public int jump(int[] nums) {
        /*
         * 这个好不容易整出来个n2的动规结果它超时了(好吧，挺容易的)
         * 也不知道有没有bug
         * 毕竟人家是困难嘛，面子要的
         *
         * 好吧，经过测试没有bug，不过面向测试用例编程(if(nums[0]==25000)return 2)挺没面子的，哈哈哈哈哈，当场笑死
         */
        int i, j, curMinStep;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (i = 1; i < nums.length; i++) {
            curMinStep = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    curMinStep = Math.min(curMinStep, dp[j] + 1);
                }
            }
            dp[i] = curMinStep;
        }
        return dp[nums.length - 1];
        /* 时间O(n2) 空间O(n) */
    }
}
