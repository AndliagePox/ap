/*
 * Author: Andliage Pox
 * Date: 2020-01-13
 */

package leetcode;

import java.util.Stack;

public class Solution00155 {
    /*
     * 最小栈？你看我长得像不像个栈？
     * 这个东西其他地方没什么说的，都是O(1)
     * 提高效率的点就在如何找最小值，暴力找就O(n)
     * 想办法降一下，比如整个别的东西来存最小值而不是找
     * 又或者整个别的办法来找最小值(这个方案吧，一看就没救)
     *
     * 我们让辅助栈(minStack)顶保存当前栈里最小的元素
     * (且同步两个栈的pop和push操作）
     * 这事咋办到呢？看push
     */
    private Stack<Integer> dataStack, minStack;

    public static void main(String[] args) {
        Solution00155 minStack = new Solution00155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public Solution00155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        /*
         * 如果辅助栈顶存的是最小元素，那么
         * 新元素如果小于最小元素
         * push后最小元素就是新元素，同样pop了这个新元素，辅助栈顶也将被pop，辅助栈顶还是最小的
         * 如果不是，那最小元素还是原来的辅助栈顶元素，给辅助栈再push一遍
         *
         * 又已知，当栈里只有一个元素的话，辅助栈顶确实是最小元素
         * 得证(所以这叫个啥法？)
         */
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            int t = minStack.peek();
            if (t > x) {
                minStack.push(x);
            } else {
                minStack.push(t);
            }
        }
    }

    public void pop() {
        /*
         * 一起pop哦
         */
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /*
     * 那么综上所述：时间O(1)空间O(n)
     * 以及我发现leetcode的运行时间是有波动的，同一套代码或许时间会不一样，所以就不要太在意了
     * 差不多就行了
     */
}