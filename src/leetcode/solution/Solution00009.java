/*
 * Author: Andliage Pox
 * Date: 2020-02-01
 */

package leetcode.solution;

public class Solution00009 {
    public static void main(String[] args) {
        int x = 101;
        System.out.println(new Solution00009().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        /* 判回文串，凑数++ */

        /* 偷鸡摸狗的剪枝 */
        if (x == 0) {
            return true;
        }
        if (x < 0 || (x % 10) == 0) {
            return false;
        }

        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
        /* 时间O(n)空间O(1) */
    }
}
