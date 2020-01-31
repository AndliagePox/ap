/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode;

public class Solution00171 {
    public static void main(String[] args) {
        String s = "AA";
        System.out.println(new Solution00171().titleToNumber(s));
    }

    public int titleToNumber(String s) {
        /*
         * 这我好像做过，不对，那个是numberToTitle
         * 反正这个更简单了
         * 好像还可以改进的样子
         * 比如正扫每次n * 26
         */
        int i, n = 0, base = 1;
        char[] chars = s.toCharArray();
        for (i = chars.length - 1; i >= 0; i--) {
            n += (chars[i] - 'A' + 1) * base;
            base *= 26;
        }
        return n;
        /* 时间O(n)空间O(1) */
    }
}
