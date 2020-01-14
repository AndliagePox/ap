/*
 * Author: Andliage Pox
 * Date: 2020-01-14
 */

package leetcode;

import java.util.Arrays;

public class Solution00167 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution00167().twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int head = 0, tail = numbers.length - 1, tempSum;
        do {
            tempSum = numbers[head] + numbers[tail];
            if (tempSum == target) {
                return new int[] {head + 1, tail + 1};
            }
            if (tempSum > target) {
                tail--;
            } else {
                head++;
            }
        } while (head != tail);
        return null;
        /*
         * 同00001，这回倒好，连序都不用排了直接O(n)，所以我做它干啥？凑数吗？
         */
    }
}
