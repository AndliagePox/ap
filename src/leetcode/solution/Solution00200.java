/*
 * Author: Andliage Pox
 * Date: 2020-04-20
 */

package leetcode.solution;

public class Solution00200 {
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '0'},
            {'0', '1'}
        };
        System.out.println(new Solution00200().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        /*
         * Solution还是写点注释吧
         * 不过主要的点就是把搜索过的格子可以直接赋0
         */
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length, m = grid[0].length, i, j, count = 0;
        if (m == 0) return 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
        /*
         * 时间虽然递归dfs，但节点就那么多，O(mn)
         * 空间上虽然没有开额外空间，但考虑递归栈，最坏O(mn)
         * (所以我为什么有这么多虽然但是？)
         */
    }

    private void dfs(char[][] grid, int r, int c) {
        int n = grid.length, m = grid[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m) return;

        if (grid[r][c] == '1') {
            grid[r][c] = '0';
            dfs(grid, r, c + 1);
            dfs(grid, r, c - 1);
            dfs(grid, r + 1, c);
            dfs(grid, r - 1, c);
        }
    }
}
