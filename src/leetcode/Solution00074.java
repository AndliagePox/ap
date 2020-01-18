/*
 * Author: Andliage Pox
 * Date: 2020-01-19
 */

package leetcode;

public class Solution00074 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}};
        int target = 31;
        System.out.println(new Solution00074().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        /* 花里胡哨的二分查找 */
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length, mIndex, nIndex;
        int mid, start = 0, end = m * n - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            mIndex = mid / n;
            nIndex = mid % n;
            if (matrix[mIndex][nIndex] == target) {
                return true;
            }
            if (matrix[mIndex][nIndex] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
        /* 时间O(log n)空间O(1) */
    }
}
