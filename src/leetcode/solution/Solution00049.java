/*
 * Author: Andliage Pox
 * Date: 2020-01-27
 */

package leetcode.solution;

import java.util.*;

public class Solution00049 {
    public static void main(String[] args) {
        String[] strs = {"acc", "cac", "abq"};
        List<List<String>> lists = new Solution00049().groupAnagrams(strs);
        for (List<String> list: lists) {
            for (String s: list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        /*
         * 话说为什么这个复杂度低的方法反而慢呢？
         * 不过两种方法都是用哈希，也没什么说的
         */
        Map<String, List<String>> map = new HashMap<>();

        int[] buf = new int[26];
        String key;
        StringBuilder keySB;
        List<String> newList;
        for (String s: strs) {
            Arrays.fill(buf, 0);
            /* 构造"/1/3/0……"样字符串做键 */
            for (char c: s.toCharArray()) {
                buf[c - 'a']++;
            }
            keySB = new StringBuilder();
            for (int t: buf) {
                keySB.append('/');
                keySB.append(t);
            }
            key = keySB.toString();
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                newList = new ArrayList<>();
                newList.add(s);
                map.put(key, newList);
            }
        }

        return new ArrayList<>(map.values());
        /* 时间O(kn)空间O(kn) n为strs长度，k为最长字符串长度 */
    }
}
