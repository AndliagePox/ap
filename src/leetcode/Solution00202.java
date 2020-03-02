/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode;

public class Solution00202 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(new Solution00202().isHappy(n));
    }

    public boolean isHappy(int n) {
        /* 对于判断环的问题，双指针就非常好使了 */
        int fast = n;
        int slow = n;

        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);

        return slow == 1;
        /*
         * 空间复杂度O(1)
         * 时间我还真有点说不清楚
         */
    }

    private int next(int n) {
        int next = 0;
        while (n != 0) {
            int t = n % 10;
            next += t * t;
            n /= 10;
        }
        return next;
    }
}
