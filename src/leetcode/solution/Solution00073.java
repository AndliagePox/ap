/*
 * Author: Andliage Pox
 * Date: 2020-01-19
 */

package leetcode.solution;

public class Solution00073 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        new Solution00073().setZeroes(matrix);
        for (int[] row: matrix) {
            for (int n: row) {
                System.out.print(n);
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        /*
         * 没什么复杂的，只要找到为0的列索引和行索引，然后赋值就好了
         */
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int row, col, n = matrix.length, m = matrix[0].length;
        boolean[] rowTags = new boolean[n], colTags = new boolean[m];

        for (row = 0; row < n; row++) {
            for (col = 0; col < m; col++) {
                if (matrix[row][col] == 0) {
                    rowTags[row] = true;
                    colTags[col] = true;
                }
            }
        }

        for (row = 0; row < n; row++) {
            if (rowTags[row]) {
                for (col = 0; col < m; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (col = 0; col < m; col++) {
            if (colTags[col]) {
                for (row = 0; row < n; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        /*
         * 时间复杂度O(mn)空间O(m + n)
         * 想到一手空间O(1)的，但后来逐渐想歪，就没有使，
         * 后来看了网友，用0在行首列首标记是不会出问题的，那俩位置已经扫过了，不是么？
         * 所以甚至引申出了这么一个问题：如何寻找一个数组中不存在的数
         */
    }
}
