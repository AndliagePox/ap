/*
 * Author: Andliage Pox
 * Date: 2020-01-27
 */

package leetcode.solution;

import java.util.Arrays;

public class Solution00016 {
    public static void main(String[] args) {
        int[] nums = {-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
        int target = 0;
        System.out.println(new Solution00016().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        /*
         * 刚开始写的乱七八糟的，我觉得不行，看来还是要想清楚再写
         * 还是先排序然后双指针两头逼近，遍历完整个数组(我讨厌这个题)
         */
        int closest = nums[0] + nums[1] + nums[2];
        int i, j, t, base, n = nums.length;
        Arrays.sort(nums);
        for (base = 0; base < n - 1; base++) {
            i = base + 1;
            j = n - 1;
            while (i < j) {
                t = nums[i] + nums[base] + nums[j];
                if (t == target) {
                    return target;
                }
                if (Math.abs(t - target) < Math.abs(closest - target)) {
                    closest = t;
                }
                if (t < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return closest;
        /*
         * 时间O(n^2) (也许是因为它时间复杂度太高了所以我不喜欢它)
         * 空间O(1)
         */
    }
}
