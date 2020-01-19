/*
 * Author: Andliage Pox
 * Date: 2020-01-20
 */

package leetcode;

public class Solution00136 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 3};
        System.out.println(new Solution00136().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        /* 异或运算异或运算异或运算 */
        int a = 0;
        for (int n: nums) {
            a ^= n;
        }
        return a;
        /* 时间O(n)空间O(1)*/
    }
}
