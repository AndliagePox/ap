/*
 * Author: Andliage Pox
 * Date: 2020-04-15
 */

package leetcode.cci;

public class CCI_08_03 {
    public static void main(String[] args) {
        System.out.println(new CCI_08_03().findMagicIndex(new int[]{1, 1, 1}));
    }

    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                return i;
            } else if (nums[i] > i) {
                i = nums[i];
            } else {
                i++;
            }
        }

        return -1;
    }
}
