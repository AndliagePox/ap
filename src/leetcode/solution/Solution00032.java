/*
 * Author: Andliage Pox
 * Date: 2020-02-04
 */

package leetcode.solution;

public class Solution00032 {
    public static void main(String[] args) {
        String s = "(()()";
        System.out.println(new Solution00032().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        /*
         * 只要括号数量不滑坡，总是有效的
         */
        int i, left = 0, right = 0, longest = 0;

        /* 正向扫一遍 */
        for (i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                longest = Math.max(longest, left << 1);
            }
            if (right > left) {
                left = right = 0;
            }
        }

        /* 反向再扫一遍，就避免了一些没完结的情况 */
        left = right = 0;
        for (i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                longest = Math.max(longest, left << 1);
            }
            if (left > right) {
                left = right = 0;
            }
        }

        return longest;
        /* 时间O(n) 空间O(1) */
    }
}
