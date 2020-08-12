package leetcode.solution;

public class Solution00231 {
    public static void main(String[] args) {
        System.out.println(new Solution00231().isPowerOfTwo(1));
        System.out.println(new Solution00231().isPowerOfTwo(2));
        System.out.println(new Solution00231().isPowerOfTwo(3));
    }

    public boolean isPowerOfTwo(int n) {
        /*
         * 这么神奇的题不多了，
         * 2的n次方在二进制中就是只有一个1，
         * 献上消1大法：n & n - 1，
         * 小于0的情况直接false
         */
        return n > 0 && (n & n - 1) == 0;
        /* 时空都是O(1) */
    }
}
