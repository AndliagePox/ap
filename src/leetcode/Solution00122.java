/*
 * Author: Andliage Pox
 * Date: 2020-01-14
 */

package leetcode;

public class Solution00122 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution00122().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        /*
         * 唯一的问题是最好的买法是什么？
         * 这个问题，在金钱的诱惑下，很好看出来
         * 谷买峰卖，那么问题就来到了如何找波峰波谷这边
         */
        int i = 0, top, valley, profit = 0;
        while (i + 1 < prices.length) {
            while (i + 1 < prices.length && prices[i + 1] <= prices[i]) {
                i++;
            }
            valley = prices[i];
            while (i + 1 < prices.length && prices[i + 1] >= prices[i]) {
                i++;
            }
            top = prices[i];
            profit += top - valley;
        }
        return profit;
        /*
         * 总之，没有问题，复杂度时间O(n)空间O(1)
         */
    }
}
