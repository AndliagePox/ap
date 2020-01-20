/*
 * Author: Andliage Pox
 * Date: 2020-01-21
 */

package leetcode;

public class Solution00344 {
    public static void main(String[] args) {
        char[] s = {'t', 's', 'a', 'k'};
        new Solution00344().reverseString(s);
        for (char c: s) {
            System.out.print(c);
        }
    }

    public void reverseString(char[] s) {
        /* 整个反转字符串来凑个数 */
        char t;
        int i, n = s.length;
        for (i = 0; i < n / 2; i++) {
            t = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = t;
        }
        /* 时间O(n)空间O(1) */
    }
}
