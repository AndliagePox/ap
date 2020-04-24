/*
 * Author: Andliage Pox
 * Date: 2020-04-23
 */

package leetcode.cci;

public class CCI_08_11 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new CCI_08_11().waysToChange(n));
    }

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int c : new int[]{1, 5, 10, 25}) {
            for (int i = c; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - c]) % 1000000007;
            }
        }

        return dp[n];
    }
}
