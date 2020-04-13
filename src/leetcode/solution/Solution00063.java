/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode.solution;

public class Solution00063 {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(new Solution00063().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
         * 和上一题没太大区别，障碍物那个格子dp当0好了
         * 不过好像写的不够优雅
         */
        int i, j, m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 0) {
            obstacleGrid[0][0] = 1;
        } else {
            return 0;
        }
        for (i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            } else {
                for (; i < m; i++) {
                    obstacleGrid[i][0] = 0;
                }
            }
        }
        for (j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                obstacleGrid[0][j] = 1;
            } else {
                for (; j < n; j++) {
                    obstacleGrid[0][j] = 0;
                }
            }
        }

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
        /*
         * 时间还是O(mn)
         * 不过空间的事就得看我能不能修改obstacleGrid了
         * 能的话就是O(1)不能就是O(mn)或者O(n)
         * (话说我用的O(1)的啊，咋才15%，我觉得它那统计不靠谱)
         */
    }
}
