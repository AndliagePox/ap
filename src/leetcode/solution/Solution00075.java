/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode.solution;

import java.util.Arrays;

public class Solution00075 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        new Solution00075().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        /*
         * 有点东西，看来我对这个东西理解不精啊
         * 据说是什么经典的国旗排序问题
         * 花里胡哨地整三个指针，思路还是没问题的
         */
        int cur = 0, p0 = 0, p2 = nums.length - 1;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, cur++, p0++);
            }else if (nums[cur] == 2) {
                swap(nums, cur, p2--);
            } else {
                cur++;
            }
        }
        /* 时间O(n)空间O(1) */
    }


    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
