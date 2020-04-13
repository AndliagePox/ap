/*
 * Author: Andliage Pox
 * Date: 2020-02-06
 */

package leetcode.solution;

import leetcode.Util;
import leetcode.ds.ListNode;

public class Solution00083 {
    public static void main(String[] args) {
        ListNode head = Util.buildLinkedList(new int[]{1, 1, 2, 3, 3, 4, 4});
        Util.printLinkedList(new Solution00083().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        /* 舞弄指针的简单问题 */
        ListNode cur = head;
        ListNode scan;
        while (cur != null) {
            scan = cur.next;
            while (scan != null && scan.val == cur.val) {
                scan = scan.next;
            }
            cur.next = scan;
            cur = cur.next;
        }
        return head;
        /* 时间O(n) 空间O(1) */
    }
}
