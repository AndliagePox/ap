/*
 * Author: Andliage Pox
 * Date: 2020-01-17
 */

package leetcode.solution;

import leetcode.ds.ListNode;

public class Solution00061 {
    public static void main(String[] args) {
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        ListNode lr = new Solution00061().rotateRight(l, 2);
        while (lr != null) {
            System.out.print(lr.val);
            lr = lr.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 0) {
            return head;
        }

        int i, n = 1; // 链表长度
        ListNode temp = head, result;

        /*
         * 统计长度+成环
         */
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }
        temp.next = head; // temp指向原来的尾结点

        /*
         * 寻找新的链表头和尾，旋转k即倒数第k个结点作为新头
         * 结束后temp指向新尾结点
         */
        k = k % n;
        for (i = 0; i < n - k; i++) {
            temp = temp.next;
        }

        result = temp.next;
        temp.next = null;
        return result;
        /*
         * 时间O(n)空间O(1)
         */
    }
}
