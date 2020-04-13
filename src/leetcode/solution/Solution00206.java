/*
 * Author: Andliage Pox
 * Date: 2020-01-21
 */

package leetcode.solution;

import leetcode.ds.ListNode;

public class Solution00206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head = new Solution00206().reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        /*
         * 再整个反转链表凑数
         * 其实一开始想听复杂的，一细想、一写，非常简单
         */
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
        /* 时间O(n)空间O(1) (这句话好像被我复杂了很多遍的样子)*/
    }
}
