/*
 * Author: Andliage Pox
 * Date: 2020-04-13
 */

package leetcode.cci;

import leetcode.Util;
import leetcode.ds.ListNode;

public class CCI_02_06 {
    public static void main(String[] args) {
        ListNode list = Util.buildLinkedList(new int[]{1, 2, 3, 2, 1});
        System.out.println(new CCI_02_06().isPalindrome(list));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode revStart = head;
        ListNode revHelp  = head;
        while (revHelp.next != null && revHelp.next.next != null) {
            revHelp = revHelp.next.next;
            revStart = revStart.next;
        }

        ListNode pre = null, nex;
        ListNode cur = revStart.next;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }

        ListNode tail = pre;
        while (head != null && tail != null) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
