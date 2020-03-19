/*
 * Author: Andliage Pox
 * Date: 2020-03-19
 */

package leetcode;

public class Solution00409 {
    public static void main(String[] args) {
        String s = "test";
        System.out.println(new Solution00409().longestPalindrome(s));
    }

    public int longestPalindrome(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];

        for (char c: s.toCharArray()) {
            if (c <= 'Z') upper[c - 'A']++;
            else lower[c - 'a']++;
        }

        int lp = 0, flag = 0;
        for (int i = 0; i < 26; i++) {
            if ((upper[i] & 1) == 0) {
                lp += upper[i];
            } else {
                lp += upper[i] - 1;
                flag = 1;
            }
            if ((lower[i] & 1) == 0) {
                lp += lower[i];
            } else {
                lp += lower[i] - 1;
                flag = 1;
            }
        }

        return lp + flag;
    }
}
