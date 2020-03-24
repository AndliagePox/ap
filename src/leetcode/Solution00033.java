/*
 * Author: Andliage Pox
 * Date: 2020-01-18
 */

package leetcode;

public class Solution00033 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new Solution00033().search(nums, target));
    }

    public int search(int[] nums, int target) {
        /*
         * 将数组分成两部分进行二分查找
         */
        int rotatedIndex = findRotatedIndex(nums); // 旋转索引，第二部分的开始索引

        if (rotatedIndex == 0) { // 没旋转
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        /*
         * 通过比较第一个元素和target可以判断target在哪一部分
         * 分别进行搜索即可
         */
        if (nums[0] > target) {
            return binarySearch(nums, target, rotatedIndex, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, rotatedIndex - 1);
        }
        /*
         * 时间O(log n)空间O(1)
         */
    }

    private int findRotatedIndex(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[mid] < nums[start]) end = mid - 1;
            else start = mid + 1;
        }
        return 0;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
