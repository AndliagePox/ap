/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode.solution;

public class Solution00190 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(new Solution00190().reverseBits(n));
    }

    public int reverseBits(int n) {
        /* 似乎位移有很多种写法，不过本质都是一样的 */
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | ((n >> i) & 1);
        }
        return res;
        /* 时间O(n)||O(1) 空间O(1) */
    }
}
