/*
 * Author: Andliage Pox
 * Date: 2020-02-19
 */

package leetcode.solution;

public class Solution00674 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(new Solution00674().findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        /* 顺序扫描就好 */
        if (nums == null || nums.length == 0) return 0;
        int resLen = 1, curLen = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1]) curLen++;
            else {
                resLen = Math.max(resLen, curLen);
                curLen = 1;
            }
        resLen = Math.max(resLen, curLen);
        return resLen;
        /* 时间O(n) 空间O(1) */
    }
}
