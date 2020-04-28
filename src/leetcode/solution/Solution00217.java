/*
 * Author: Andliage Pox
 * Date: 2020-04-28
 */

package leetcode.solution;

import java.util.HashSet;

public class Solution00217 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(new Solution00217().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        /*
         * 挺简单的一个东西，哈希存储天下第一++
         * 主要是想玩我的新版IDEA
         */
        if (nums == null) return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }

        return false;
        /*
         * 两个O(n)
         */
    }
}
