/*
 * Author: Andliage Pox
 * Date: 2020-03-16
 */

package leetcode;

import java.util.Arrays;

public class Solution00034 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4};
        int target = 3;
        System.out.println(Arrays.toString(new Solution00034().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] {searchLeft(nums, target), searchRight(nums, target)};
    }

    private int searchLeft(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private int searchRight(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) return mid;
            if (nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
