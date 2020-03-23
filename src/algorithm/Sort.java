/*
 * Author: Andliage Pox
 * Date: 2020-02-09
 */

package algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int times = 10000000;
        int[] a, src = {
                5, 1, 3, 4, 5, 6, 1, 3, 5, 1, 88, 90, 243, 123,
                123, 66, 123, 11, 79, 21, 23, 73, 11, 32, 0, 5,
                123, 22, 212421, 32, 321, 11, 3, 4, 6, 66, 77, 12,
                32, 41, 21, 43, 667, 2343, 12, 321, 55, 12, 42, 5,
                1, 32, -12, -42, 12, -22, 41, 80, 22, 21, 667, 21, 2,
                3, 33, 3, 77, 8, 6, 1, 5, 1, 3, 5, 66, 11322, 5555, 23215,
                13, 325, 22, 65, 78, 20, 90, -10, 750, 501, 512, 66,
                44, -22, -30, -91, 51, 60, 2213, 65, 88, 8
        };
        long ts, te;

        ts = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            a = src.clone();
            quicksort(a, 0, a.length - 1);
        }
        te = System.currentTimeMillis();
        System.out.println("Self Quick Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            a = src.clone();
            switchSort(a);
        }
        te = System.currentTimeMillis();
        System.out.println("Self Switch Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            a = src.clone();
            Arrays.sort(a);
        }
        te = System.currentTimeMillis();
        System.out.println("System DPQ Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            a = src.clone();
            selectSort(a);
        }
        te = System.currentTimeMillis();
        System.out.println("Self Select Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            a = src.clone();
            doubleSelectSort(a);
        }
        te = System.currentTimeMillis();
        System.out.println("ZYY Double Select Sort " + (te - ts) + "ms");
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

    public static void selectSort(int[] a) {
        int i, j, min, mi, t;
        for (i = 0; i < a.length; i++) {
            min = a[i];
            mi = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    mi = j;
                }
            }
            t = a[i];
            a[i] = a[mi];
            a[mi] = t;
        }
    }

    public static void doubleSelectSort(int[] a) {
        int i, j, min, mi, max, ma, t;
        for (i = 0; i < a.length / 2; i++) {
            min = a[i];
            mi = i;
            max = a[i];
            ma = i;
            for (j = i + 1; j < a.length - i; j++) {
                if (a[j] < min) {
                    min = a[j];
                    mi = j;
                }
                if (a[j] > max) {
                    max = a[j];
                    ma = j;
                }
            }
            t = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[ma];
            a[ma] = t;
            t = a[i];
            a[i] = a[mi];
            a[mi] = t;
        }
    }
}
