/*
 * Author: Andliage Pox
 * Date: 2020-02-09
 */

package algorithm;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] a, src = {
                5, 1, 3, 4, 5, 6, 1, 3, 5, 1, 88, 90, 243, 123,
                123, 66, 123, 11, 79, 21, 23, 73, 11, 32, 0, 5,
                123, 22, 212421, 32, 321, 11, 3, 4, 6, 66, 77, 12,
                32, 41, 21, 43, 667, 2343, 12, 321, 55, 12, 42, 5,
                1, 32, -12, -42, 12, -22, 41, 80, 22, 21, 667, 21, 2,
                3, 33, 3, 77, 8
        };
        long ts, te;
        ts = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            a = src.clone();
            quicksort(a, 0, a.length - 1);
        }
        te = System.currentTimeMillis();
        System.out.println("Self Q " + (te - ts) + "ms");
        ts = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            a = src.clone();
            switchSort(a);
        }
        te = System.currentTimeMillis();
        System.out.println("Self S " + (te - ts) + "ms");
        ts = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            a = src.clone();
            Arrays.sort(a);
        }
        te = System.currentTimeMillis();
        System.out.println("System DPQ " + (te - ts) + "ms");
    }

    public static void quicksort(int[] a, int start, int end) {
        if (start >= end) return;
        int x, l = start, r = end;
        x = a[l];
        while (l < r) {
            while (l < r && a[r] > x) r--;
            a[l] = a[r];
            while (l < r && a[l] <= x) l++;
            a[r] = a[l];
        }
        a[l] = x;
        quicksort(a, start, r - 1);
        quicksort(a, l + 1, end);
    }

    public static void switchSort(int[] a) {
        int i, j, t;
        for (i = 0; i < a.length; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }
}
