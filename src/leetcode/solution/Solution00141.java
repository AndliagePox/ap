/*
 * Author: Andliage Pox
 * Date: 2020-01-20
 */

package leetcode.solution;

import leetcode.ds.ListNode;

public class Solution00141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        System.out.println(new Solution00141().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        /* 双指针判断环形链表 */
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
        /* 时间O(n)空间O(1) */
    }
}
