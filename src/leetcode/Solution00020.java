/*
 * Author: Andliage Pox
 * Date: 2020-02-04
 */

package leetcode;

import java.util.Stack;

public class Solution00020 {
    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(new Solution00020().isValid(s));
    }

    public boolean isValid(String s) {
        /* 判括号是否有效就是基础的用栈，一种两种三种都是一样的 */
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.empty();
        /* 时间O(n) 空间O(n) */
    }

    private boolean isMatch(char l, char r) {
        return l == '(' && r == ')' || l == '[' && r == ']' || l == '{' && r == '}';
    }
}
