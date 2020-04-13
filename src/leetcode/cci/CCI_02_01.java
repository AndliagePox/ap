/*
 * Author: Andliage Pox
 * Date: 2020-04-13
 */

package leetcode.cci;

import leetcode.Util;
import leetcode.ds.ListNode;

import java.util.HashSet;

public class CCI_02_01 {
    public static void main(String[] args) {
        Util.printLinkedList(new CCI_02_01().removeDuplicateNodes(Util.buildLinkedList(new int[]{1, 2, 3, 3, 2, 1})));
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode nex;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);

        while (cur != null) {
            nex = cur.next;
            if (set.contains(cur.val)) {
                pre.next = nex;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = nex;
        }

        return head;
    }
}
