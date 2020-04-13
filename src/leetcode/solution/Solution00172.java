/*
 * Author: Andliage Pox
 * Date: 2020-02-26
 */

package leetcode.solution;

public class Solution00172 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution00172().trailingZeroes(n));
    }

    public int trailingZeroes(int n) {
        /*
         * 这是个数学题，众所周知，只有2 * 5 = 10会搞出来一个0
         * (10本身也是2 * 5，x * 10 = x * 2 * 5)
         * 总之每出现一次5(每5个数)就会多一个0，那就好办了
         * 后来发现25 * 4能搞出来两个0，其中一个是25 = 5 * 5
         * 另一个就是25的问题了，每25个数会额外整出来一个0
         * 以此类推125、525、……再额外一个
         */
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
        /* 时间O(log n) 空间O(1) */
    }
}
