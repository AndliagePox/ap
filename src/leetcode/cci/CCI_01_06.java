/*
 * Author: Andliage Pox
 * Date: 2020-04-13
 */

package leetcode.cci;

public class CCI_01_06 {
    public static void main(String[] args) {
        String s = "test";
        System.out.println(new CCI_01_06().compressString(s));
    }

    public String compressString(String S) {
        int count = 0;
        char curChar = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (c != curChar) {
                if (count != 0) sb.append(count);
                sb.append(c);
                curChar = c;
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        return sb.length() >= S.length() ? S : sb.toString();
    }
}
