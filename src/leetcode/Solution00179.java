/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution00179 {
    public static void main(String[] args) {
        int[] nums = {10, 2};
        System.out.println(new Solution00179().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        /*
         * 先排序，然后顺序输出就好了
         * 巧就巧在怎么排序了
         * 我总觉得这样搞(指整数转字符串)效率挺底的，但暂且没什么其他办法
         */
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });

        // [0, 0, 0]的坑
        if (numStrs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String numStr: numStrs) {
            sb.append(numStr);
        }
        return sb.toString();
        /*
         * 排个序时间O(n * log n)
         * 建个字符串数组空间O(n)
         */
    }
}
