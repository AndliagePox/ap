/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode;

public class Solution00191 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution00191().hammingWeight(n));
    }

    public int hammingWeight(int n) {
        /* 汉明宽度这种事，老位操作了n & (n - 1) */
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
        /* 时间O(n)||O(1) 空间O(1) */
    }
}
