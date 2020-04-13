/*
 * Author: Andliage Pox
 * Date: 2020-01-15
 */

package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution00046 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution00046().permute(nums);
        for (List<Integer> list: lists) {
            for (Integer num: list) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        generateList(lists, nums, 0);
        return lists;
        /*
         * 基础的全排列，空间时间O(n!)(话说我一直对这个阶乘阶复杂度心存疑惑)
         */
    }

    private void generateList(List<List<Integer>> lists, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num: nums) {
                list.add(num);
            }
            lists.add(list);
            return;
        }
        int i;
        for (i = index; i < nums.length; i++) {
            swap(nums, index, i);
            generateList(lists, nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
