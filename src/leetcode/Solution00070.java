/*
 * Author: Andliage Pox
 * Date: 2020-02-05
 */

package leetcode;

public class Solution00070 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(new Solution00070().climbStairs(n));
    }

    public int climbStairs(int n) {
        /*
         * 爬楼梯，这是斐波那契数列
         */
        if (n < 3) return n;
        int[] methods = new int[n + 1];
        methods[1] = 1;
        methods[2] = 2;
        for (int i = 3; i <= n; i++)
            methods[i] = methods[i - 1] + methods[i - 2];
        return methods[n];
        /*
         * 时间O(n)
         * 空间O(n) 不过似乎并不用搞个数组出来，用三个变量就可以了，但是会多几个赋值操作，也许慢一点
         */
    }
}
