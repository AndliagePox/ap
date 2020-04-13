/*
 * Author: Andliage Pox
 * Date: 2020-02-16
 */

package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution00448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        for (int t: new Solution00448().findDisappearedNumbers(nums)) System.out.println(t);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
         * 许久未写，我感觉我身手还不错
         * 本题将数组自己作为哈希表，这思路我门清
         */
        List<Integer> list = new ArrayList<>();

        int i, n = nums.length;
        for (i = 0; i < n; i++) {
            int hash = Math.abs(nums[i]);
            if (hash == n) hash = 0;
            nums[hash] = -Math.abs(nums[hash]);
        }

        // 我还是好喜欢这个风格，注释写好就好
        for (i = 1; i < n; i++) if (nums[i] > 0) list.add(i);

        // n > 0是判断是否为空数组的
        if (n > 0 && nums[0] > 0) list.add(n);

        return list;
        /* 时间O(n) 空间O(1) */
    }
}
