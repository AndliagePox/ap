/*
 * Author: Andliage Pox
 * Date: 2020-02-09
 */

package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] a;
        int arrays = 1000, times = 1000, length = 500;
        List<int[]> list = new ArrayList<>(arrays);
        long ts, te;

        for (int i = 0; i < arrays; i++) {
            list.add(generateRandomArray(length));
        }

        ts = System.currentTimeMillis();
        for (int[] src: list) {
            for (int i = 0; i < times; i++) {
                a = src.clone();
                quickSort(a, 0, a.length - 1);
            }
        }
        te = System.currentTimeMillis();
        System.out.println("Self Quick Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int[] src: list) {
            for (int i = 0; i < times; i++) {
                a = src.clone();
                switchSort(a);
            }
        }
        te = System.currentTimeMillis();
        System.out.println("Self Switch Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int[] src: list) {
            for (int i = 0; i < times; i++) {
                a = src.clone();
                Arrays.sort(a);
            }
        }
        te = System.currentTimeMillis();
        System.out.println("System DPQ Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int[] src: list) {
            for (int i = 0; i < times; i++) {
                a = src.clone();
                selectSort(a);
            }
        }
        te = System.currentTimeMillis();
        System.out.println("Self Select Sort " + (te - ts) + " ms");

        ts = System.currentTimeMillis();
        for (int[] src: list) {
            for (int i = 0; i < times; i++) {
                a = src.clone();
                doubleSelectSort(a);
            }
        }
        te = System.currentTimeMillis();
        System.out.println("ZYY Double Select Sort " + (te - ts) + "ms");

        ts = System.currentTimeMillis();
        for (int[] src: list) {
            for (int i = 0; i < times; i++) {
                a = src.clone();
                bubbleSort(a);
            }
        }
        te = System.currentTimeMillis();
        System.out.println("Self Bubble Sort " + (te - ts) + "ms");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[(int) (size * Math.random() + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (10000 * Math.random());
        }
        return arr;
    }

    public static void quickSort(int[] a, int start, int end) {
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
        quickSort(a, start, r - 1);
        quickSort(a, l + 1, end);
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

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }
}
