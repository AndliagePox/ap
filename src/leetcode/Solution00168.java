/*
 * Author: Andliage Pox
 * Date: 2020-01-12
 */

package leetcode;

import java.util.Stack;

public class Solution00168 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution00168().convertToTitle(n));
    }

    private String convertToTitle(int n) {
        /*
         * 乍一看是个26进制，然而这个数字是从1-26，而非0-25
         * 结果还是个26进制，就没什么说的了
         */
        StringBuilder sb = new StringBuilder();
        // 至于这个栈……我忘了sb.reverse()了[捂脸](话说代码里中括号可不少，再拿这东西标注表情包好像不合适，那就)[#捂脸]吧
        Stack<Character> stack = new Stack<>();
        Character curDigit;
        int curIndex;
        while (n != 0) {
            curIndex = n % 26;
            if (curIndex == 0) {
                curIndex = 26;
            }
            curDigit = (char)('A' - 1 + curIndex);
            n = (n - curIndex) / 26;
            stack.push(curDigit);
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
        /*
         * 是不是还有综上所述分析复杂度？时间空间都是O(log n)吧
         */
    }
}
