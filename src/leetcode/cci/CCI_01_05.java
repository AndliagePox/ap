/*
 * Author: Andliage Pox
 * Date: 2020-04-16
 */

package leetcode.cci;

public class CCI_01_05 {
    public static void main(String[] args) {
        String first = "test";
        String second = "tes";
        System.out.println(new CCI_01_05().oneEditAway(first, second));
    }

    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length(), secondLen = second.length();

        if (Math.abs(firstLen - secondLen) >= 2) return false;

        String longer, shorter;
        if (firstLen > secondLen) {
            longer = first;
            shorter = second;
        } else {
            longer = second;
            shorter = first;
        }
        char[] longerChars = longer.toCharArray();
        char[] shorterChars = shorter.toCharArray();
        boolean chance = true;

        if (firstLen == secondLen) {
            for (int i = 0; i < firstLen; i++) {
                if (longerChars[i] == shorterChars[i]) continue;
                if (chance) {
                    chance = false;
                } else {
                    return false;
                }
            }
        } else {
            int i = 0, j = 0;
            while (i != longer.length() && j != shorter.length()) {
                if (longerChars[i] == shorterChars[j]) {
                    i++;
                    j++;
                } else {
                    if (chance) {
                        i++;
                        chance = false;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
