/*
 * Author: Andliage Pox
 * Date: 2020-01-12
 */

package leetcode;

import java.util.Arrays;

public class Solution00001 {
    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution00001().twoSum(nums, target)));
    }

    private int[] twoSum(int[] nums, int target) {
        int[] temp = nums.clone();
        Arrays.sort(temp); // 遇事不决先排序，就当它是O(log n)
        int i, head = 0, tail = nums.length - 1, tempSum;
        int numsIndexA = -1, numsIndexB = -1;
        /*
         * 对于一个排好序的数组就很有趣了，我们搞两个指针分别指向头尾
         * 如果当前两个元素和(tempSum)大了，把尾巴向前移一个，反之移头，刚好等于，皆大欢喜
         * 这段有一说一那肯定是O(n)
         */
        do {
            tempSum = temp[head] + temp[tail];
            if (tempSum == target) {
                /*
                 * 皆大欢喜后我发现我把数组给整乱了，所以要去遍历一下原来的数组找原来的索引
                 * 还是O(n)，虽然包在O(n)的循环里面，但实际上只会执行一次
                 * (所以我是不是应该写出去？好吧，不应该，写出去就判不了是break出来的还是没找着出来的)
                 */
                for (i = 0; i < nums.length; i++) {
                    if (nums[i] == temp[head]) {
                        numsIndexA = i;
                    }
                    /*
                     * 为什么要从前面后面同时开找这种事……当我们用了两个一样的数字的时候，
                     * 从一头找就凉了啊，索引是一样的，不符合社会主义核心价值观
                     */
                    if (nums[nums.length - i - 1] == temp[tail]) {
                        numsIndexB = nums.length - i - 1;
                    }
                    if (numsIndexA >= 0 && numsIndexB >= 0) {
                        break;
                    }
                }
                return new int[] {numsIndexA, numsIndexB};
            }
            if (tempSum > target) {
                tail--;
            } else {
                head++;
            }
        } while (head != tail);
        return null;
        /*
         * 那么综上所述
         * 时间复杂度O(n * log n)，主要花在了排序上，提交2ms，99.39%也是十分喜人的
         * 空间复杂度O(n)，复制了一口数组
         *
         * 还有题解里那个哈希法我看了，实在无法苟同map.containsKey()的复杂度是O(1)
         *
         * [2020-01-14] 我要收回上面那句蠢话，确实是O(1)
         */
    }
}
