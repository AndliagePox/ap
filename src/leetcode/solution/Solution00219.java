/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode.solution;

import java.util.HashMap;

public class Solution00219 {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1, 2, 1, 5};
        System.out.println(new Solution00219().containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
         * 有趣，哈希映射天下第一
         * key是当前数字，value是上一次出现的索引
         * 扫一遍顺便查映射，<= k就true
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
        /* 时间O(n) 空间O(n) */
    }
}
