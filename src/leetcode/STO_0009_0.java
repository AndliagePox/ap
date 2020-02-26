/*
 * Author: Andliage Pox
 * Date: 2020-02-26
 */

package leetcode;

import java.util.Stack;

public class STO_0009_0 {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    public static void main(String[] args) {
        int value = 1;
        STO_0009_0 sto = new STO_0009_0();
        sto.appendTail(value);
        System.out.println(sto.deleteHead());
    }

    public void appendTail(int value) {
        data.push(value);
    }

    public int deleteHead() {
        /*
         * 每次再倒回去这事并不必要
         */
        if (!helper.empty()) {
            return helper.pop();
        } else if (data.empty()) {
            return -1;
        } else {
            while (!data.empty()) {
                helper.push(data.pop());
            }
            return helper.pop();
        }
    }
}
