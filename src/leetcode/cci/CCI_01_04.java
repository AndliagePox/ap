/*
 * Author: Andliage Pox
 * Date: 2020-04-13
 */

package leetcode.cci;

public class CCI_01_04 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new CCI_01_04().canPermutePalindrome(s));
    }

    public boolean canPermutePalindrome(String s) {
        long map = 0;
        for (char c: s.toCharArray()) map ^= 1L << (c - 64);
        return map == 0L || (map & (map - 1)) == 0L;
    }
}
