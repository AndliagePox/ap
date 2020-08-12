package leetcode.solution;

import leetcode.Util;
import leetcode.ds.ListNode;

public class Solution00234 {
    public static void main(String[] args) {
        System.out.println(new Solution00234().isPalindrome(Util.buildLinkedList(new int[]{1, 2, 3, 4})));
        System.out.println(new Solution00234().isPalindrome(Util.buildLinkedList(new int[]{1, 2, 2, 1})));
    }

    public boolean isPalindrome(ListNode head) {
        /*
         * 回文链表，先找中点，
         * 然后将中点之后的链表反转，
         * 对比两条链表，一样就是回文
         * (最后一个节点可以不看，即一条链表结束了就ok了)
         */
        if (head == null) return true;

        ListNode half = head, tail = head;

        while (tail.next != null && tail.next.next != null) {
            half = half.next;
            tail = tail.next.next;
        }

        ListNode rs = half.next;
        half.next = null;

        ListNode cur = rs, pre = null, nex;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        ListNode rd = pre;

        while (head != null && rd != null) {
            if (head.val != rd.val) return false;
            head = head.next;
            rd = rd.next;
        }

        return true;
        /* 时间O(n) 空间O(1) */
    }
}
