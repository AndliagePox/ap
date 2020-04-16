/*
 * Author: Andliage Pox
 * Date: 2020-04-16
 */

package leetcode.cci;

import leetcode.Util;
import leetcode.ds.ListNode;

public class CCI_02_04 {
    public static void main(String[] args) {
        ListNode head = Util.buildLinkedList(new int[]{3, 5, 8, 5, 10, 2, 1});
        Util.printLinkedList(new CCI_02_04().partition(head, 5));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0), sp = smaller;
        ListNode bigger = new ListNode(0), bp = bigger;

        while (head != null) {
            if (head.val < x) {
                sp.next = head;
                sp = head;
                head = head.next;
                sp.next = null;
            } else {
                bp.next = head;
                bp = bp.next;
                head = head.next;
                bp.next = null;
            }
        }

        sp.next = bigger.next;
        return smaller.next;
    }
}
