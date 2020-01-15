/*
 * Author: Andliage Pox
 * Date: 2020-01-15
 */

package leetcode;

public class Solution00041 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3};
        System.out.println(new Solution00041().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        /*
         * 这个东西就非常神奇了，你hard还是你hard
         * 大思路上就这么几件事：
         * 1.用自身作为哈希表
         * 2.正负号作为布尔值
         * 3.O(n)的算法并不意味着只扫一次
         */
        int n = nums.length, i, value;
        boolean contain1 = false;

        /*
         * 查1
         */
        for (i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contain1 = true;
                break;
            }
        }

        if (!contain1) {
            return 1;
        }

        /*
         * [1]的情况
         */
        if (n == 1) {
            return 2;
        }

        /*
         * 将数组中没啥用的数换成1
         */
        for (i = 0; i < n; i++) {
            if (nums[i] < 1 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        /*
         * 将数组下标作为键，正负号作为值，负号表示没出现过
         * 由于索引问题，用nums[0]来表示n是否存在
         */
        for (i = 0; i < n; i++) {
            value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[value] = -Math.abs(nums[value]);
            }
        }

        /*
         * 找第一个正数即第一个未出现的数
         */
        for (i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        /*
         * 没找着考虑n和n+1
         */
        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
        /*
         * 按题目要求，时间O(n)，空间O(1)
         * 但是实际上感觉没啥用，工作环境(nums)污染得妈都不认识了，建议clone
         * 那都clone了，还不如用个正儿八经的哈希表算了
         * 所以……还是就总结那三条有用吧
         */
    }
}
