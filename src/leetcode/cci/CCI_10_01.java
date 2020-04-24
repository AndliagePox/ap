/*
 * Author: Andliage Pox
 * Date: 2020-04-24
 */

package leetcode.cci;

import java.util.Arrays;

public class CCI_10_01 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {4, 5, 6};
        int m = 3;
        int n = 3;
        new CCI_10_01().merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1;
        int pb = n - 1;
        int pn = m + n - 1;

        while (pn >= 0) {
            int c = Integer.MIN_VALUE;
            int from = 0;

            if (pa >= 0 && A[pa] > c) {
                from = 1;
                c = A[pa];
            }
            if (pb >= 0 && B[pb] > c) {
                from = 2;
                c = B[pb];
            }

            A[pn--] = c;
            if (from == 1) {
                pa--;
            } else {
                pb--;
            }
        }
    }
}
