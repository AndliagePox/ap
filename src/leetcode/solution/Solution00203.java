/*
 * Author: Andliage Pox
 * Date: 2020-03-02
 */

package leetcode.solution;

import leetcode.Util;
import leetcode.ds.ListNode;

public class Solution00203 {
    public static void main(String[] args) {
        int val = 5;
        ListNode head = Util.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        Util.printLinkedList(new Solution00203().removeElements(head, val));
    }

    public ListNode removeElements(ListNode head, int val) {
        /* 有趣(并不)的基础指针操作 */
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }

        return head;
        /* 时间O(n) 空间O(1)话说我这空间咋老比人家多 */
    }
}
