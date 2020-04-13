/*
 * Author: Andliage Pox
 * Date: 2020-03-19
 */

package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution00078 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for (List<Integer> list: new Solution00078().subsets(nums)) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) list.add(nums[j]);
            }
            ans.add(list);
        }
        return ans;
    }
}
