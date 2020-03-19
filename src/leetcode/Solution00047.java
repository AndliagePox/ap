/*
 * Author: Andliage Pox
 * Date: 2020-03-19
 */

package leetcode;

import java.util.*;

public class Solution00047 {
    private int[] nums;
    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2};
        for (List<Integer> list: new Solution00047().permuteUnique(nums)) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        backtrack(0);
        return ans;
    }

    private void backtrack(int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int t: nums) list.add(t);
            ans.add(list);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(index, i);
            backtrack(index + 1);
            swap(index, i);
        }
    }

    private void swap(int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
