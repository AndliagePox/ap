/*
 * Author: Andliage Pox
 * Date: 2020-04-14
 */

package leetcode.cci;

import leetcode.ds.ListNode;

public class CCI_02_07 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode headb = headA.next = new ListNode(1);
        System.out.println(new CCI_02_07().getIntersectionNode(headA, headb).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        boolean ac = false, bc = false;

        while (a != null && b != null || a == null && !ac || b == null && !bc) {
            if (a != null && a == b) return a;

            if (a == null) {
                a = headB;
                ac = true;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
                bc = true;
            } else {
                b = b.next;
            }
        }

        return null;
    }
}
