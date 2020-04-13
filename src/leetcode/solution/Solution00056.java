/*
 * Author: Andliage Pox
 * Date: 2020-01-19
 */

package leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution00056 {
    private static final int START = 0;
    private static final int END   = 1;

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}
        };
        for (int[] interval: new Solution00056().merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public int[][] merge(int[][] intervals) {
        /* 将数组排序后就好办多了 */
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[START] - o2[START];
            }
        });
        for (int[] interval: intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[END] < interval[START]) {
                result.add(interval);
            } else {
                if (result.get(result.size() - 1)[END] < interval[END]) {
                    result.get(result.size() - 1)[END] = interval[END];
                }
            }
        }
        return result.toArray(new int[1][]);
        /*
         * 时间复杂度和空间复杂度都是O(n)
         * 但现在有这么个问题，思路都是一样的，为啥我这个提交40ms
         * 慢了一个数量级，这真是灵异问题，先留着吧
         *
         * 我去，评论真是个好东西，这lambda表达式用不得啊，一会细查下
         */
    }
}
