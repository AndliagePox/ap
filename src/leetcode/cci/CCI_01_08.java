/*
 * Author: Andliage Pox
 * Date: 2020-04-16
 */

package leetcode.cci;

public class CCI_01_08 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 1},
                {0, 1, 2}
        };
        new CCI_01_08().setZeroes(matrix);
        for (int[] row: matrix) {
            for (int c: row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;

        int n = matrix.length, m = matrix[0].length;

        int i, j;
        boolean firstRow = false;

        for (j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
            }
        }
        for (i = 1; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRow) {
            for (j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
