/*
 * Author: Andliage Pox
 * Date: 2020-04-16
 */

package leetcode.cci;

public class CCI_01_09 {
    public static void main(String[] args) {
        System.out.println(new CCI_01_09().isFlipedString("ta", "at"));
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) return false;

        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
