/*
 * Author: Andliage Pox
 * Date: 2020-02-02
 */

package leetcode;

import java.util.Arrays;

public class Solution00066 {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(new Solution00066().plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        /*
         * 从后面遍历，进位就继续，不进位返回
         */
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }

        /* 能到这一步说明我们要比原来多一位了(1000……) */
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
        /* 时间O(n) 空间O(1)||O(n) */
    }
}
