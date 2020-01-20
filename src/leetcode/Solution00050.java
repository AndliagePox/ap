/*
 * Author: Andliage Pox
 * Date: 2020-01-21
 */

package leetcode;

public class Solution00050 {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 3;
        System.out.println(new Solution00050().myPow(x, n));
    }

    public double myPow(double x, int n) {
        /* 不如再整个二分乘法凑数？ */
        if (n < 0) {
            return 1.0 / fastPow(x, -n);
        } else {
            return fastPow(x, n);
        }
        /* 时间O(log n)
         * 空间O(log n)(递归调用栈，记得某次考试还写错了这种事情)
         */
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = fastPow(x, n / 2);
        if ((n & 1) == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
