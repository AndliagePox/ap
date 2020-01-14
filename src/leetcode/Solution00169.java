/*
 * Author: Andliage Pox
 * Date: 2020-01-13
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution00169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new Solution00169().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        /*
         * 当然是哈希表来存某个数出现的次数
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num: nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        /*
         * 然后再遍历哈希表找次数最多的那个
         */
        int maxTimes = 0, maxTimesNum = 0;
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            if (entry.getValue() > maxTimes) {
                maxTimes = entry.getValue();
                maxTimesNum = entry.getKey();
            }
        }
        return maxTimesNum;
        /*
         * 时空都是O(n)，后来我看到一种效率更高的解法：
         * 投票法，太神奇了，那么请问是如何想到的呢
         */
    }
}
