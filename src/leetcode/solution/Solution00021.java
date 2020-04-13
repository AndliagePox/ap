/*
 * Author: Andliage Pox
 * Date: 2020-01-28
 */

package leetcode.solution;

import leetcode.ds.ListNode;

public class Solution00021 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode r = new Solution00021().mergeTwoLists(l1, l2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /* 合并链表凑数 */
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return result.next;
        /* 时间O(n)空间O(1) */
    }
}
