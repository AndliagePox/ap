/*
 * Author: Andliage Pox
 * Date: 2020-01-21
 */

package leetcode;

import leetcode.ds.ListNode;

public class Solution00160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(11);
        ListNode headB = new ListNode(21);
        ListNode meet = new ListNode(31);
        headA.next = new ListNode(12);
        headA.next.next = meet;
        headB.next = meet;
        System.out.println(new Solution00160().getIntersectionNode(headA, headB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
         * 双指针来找相交的点，虽然写的不够优雅，但思路是没有问题的
         * 这个事情走一波就会发现，走完本条链表走另一条，相遇的地方就是交点
         */
        if (headA == null || headB == null) {
            return null;
        }

        boolean jumpToA = false, jumpToB = false;
        ListNode a = headA, b = headB;
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }

            a = a.next;
            b = b.next;

            if (a == null && !jumpToB) {
                jumpToB = true;
                a = headB;
            }

            if (b == null && !jumpToA) {
                jumpToA = true;
                b = headA;
            }
        }

        return null;
        /* 时间O(n)空间O(1) */
    }
}
