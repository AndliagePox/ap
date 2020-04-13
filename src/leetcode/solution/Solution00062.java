/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode.solution;

public class Solution00062 {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(new Solution00062().uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        /* 乍一看是个非常简单的动规，细一看确实是 */
        int i, j;
        int[][] dp = new int[m][n];
        for (i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        /*
         * 时间空间都是O(mn)
         * 不过空间上还有优化的余地
         * 比如我发现加一次之后那行就再也没用过，所以存起来是没有必要的
         */
    }
}
