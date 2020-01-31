/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode;

import java.util.Stack;

public class Solution00071 {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(new Solution00071().simplifyPath(path));
    }

    public String simplifyPath(String path) {
        /*
         * 简化unix目录，栈是个好东西，长见识
         */
        Stack<String> dirs = new Stack<>();
        for (String cur: path.split("/")) {
            if (cur.equals("..")) {
                if (!dirs.empty()) {
                    dirs.pop();
                }
            } else if (!cur.isEmpty() && !cur.equals(".")) {
                dirs.push(cur);
            }
        }
        if (dirs.empty()) {
            return "/";
        }
        StringBuilder ans = new StringBuilder();
        for (String cur: dirs) { // 栈的迭代器居然是顺序的，好像不合适的样子
            ans.append('/').append(cur);
        }
        return ans.toString();
        /* 时间O(n)空间O(n) */
    }
}
