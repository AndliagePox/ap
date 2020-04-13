/*
 * Author: Andliage Pox
 * Date: 2020-02-26
 */

package leetcode.sto;

public class STO_0003_0 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 2, 3};
        System.out.println(new STO_0003_0().findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        /*
         * 简单的哈希表，已经极致善良到数组里的数范围都在0到n了
         */
        if (nums == null) return 0;

        int[] hashTable = new int[nums.length];
        for (int t: nums) {
            if (hashTable[t] == 0) {
                hashTable[t] = 1;
            } else {
                return t;
            }
        }

        return 0;
        /* 时间O(n) 空间O(n) */
    }
}
