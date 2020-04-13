/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode.solution;

import java.util.HashMap;

public class Solution00205 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(new Solution00205().isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        /* 哈希映射，我这个有点憨，但不想改 */
        return mapping(s, t) && mapping(t, s);
        /* 时间O(n) 空间O(n) */
    }

    private boolean mapping(String s, String t) {
        if (s.length() != t.length()) return false;

        int len = s.length();
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (map.containsKey(sc)) {
                if (map.get(sc) != tc) return false;
            } else {
                map.put(sc, tc);
            }
        }

        return true;
    }
}
