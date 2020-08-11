package leetcode.solution;

public class Solution00204 {
    public static void main(String[] args) {
        System.out.println(new Solution00204().countPrimes(5));
    }

    public int countPrimes(int n) {
        /* 熟悉一下感觉，还行 */
        if (n <= 2) return 0;
        boolean[] primMap = new boolean[n + 1];
        for (int i = 2; i <= n / 2; i++) {
            int t = n / i;
            for (int j = 2; j <= t; j++) {
                primMap[i * j] = true;
            }
        }
        primMap[1] = true;
        primMap[2] = false;
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (!primMap[i]) c++;
        }

        return c;
        /* 时间O(n2) 空间O(n) */
    }
}
