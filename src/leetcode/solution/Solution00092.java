/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode.solution;

import leetcode.Util;
import leetcode.ds.ListNode;

public class Solution00092 {
    public static void main(String[] args) {
        int m = 1, n = 3;
        ListNode head = Util.buildLinkedList(new int[]{1, 3, 6, 7});
        head = new Solution00092().reverseBetween(head, m, n);
        Util.printLinkedList(head);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        /*
         * 乍一看我以为这个东西挺简单的，然而并不
         * 不过好像也没什么难的，就是指针指来指去有些混乱
         */
        int i;
        ListNode start, startPre;
        ListNode workPre, workCur, workNext;

        /*
         * 寻找开始反转的结点和它的结点，一会链人
         * 对m==1(从头开始)特殊处理，有些麻烦
         */
        if (m == 1) {
            i = 0;
            start = head;
            startPre = null;
        } else {
            startPre = head;
            for (i = 1; i < m - 1; i++) {
                startPre = startPre.next;
            }
            start = startPre.next;
        }

        /* 开始反转，整个i计数 */
        workPre = startPre;
        workCur = start;
        while (i < n && workCur != null) {
            workNext = workCur.next;
            workCur.next = workPre;
            workPre = workCur;
            workCur = workNext;
            i++;
        }

        /*
         * 开始链人，判断startPre是不是null来决定是不是从头反转的
         * 此时workPre是反转的最后一个节点即反转部分的头结点
         */
        if (startPre != null) {
            startPre.next = workPre;
        } else {
            head = workPre;
        }

        start.next = workCur;
        return head;
        /* 时间O(n)空间O(1) */
    }
}
