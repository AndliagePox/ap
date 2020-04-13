/*
 * Author: Andliage Pox
 * Date: 2020-02-26
 */

package leetcode.sto;

import leetcode.Util;
import leetcode.ds.ListNode;

import java.util.Arrays;

public class STO_0006_0 {
    public static void main(String[] args) {
        ListNode head = Util.buildLinkedList(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(new STO_0006_0().reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
        /*
         * 虽然用栈方便，但确实有些浪费性能了
         * 或许可以尝试递归，虽然它浪费性能，但写的少啊
         */
        int count = 0;
        ListNode node = head;

        while (node != null) {
            node = node.next;
            count++;
        }

        int[] ans = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            ans[i] = head.val;
            head = head.next;
        }

        return ans;
        /* 时间O(n) 空间O(n) */
    }
}
