/*
 * Author: Andliage Pox
 * Date: 2020-01-20
 */

package leetcode;

import leetcode.ds.ListNode;

public class Solution00142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        System.out.println(new Solution00142().detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        /*
         * 找入环口，先判有没有环，再找口
         * (先问是不是，再问为什么？这句话有道理是有道理，但咋听着不舒服呢)
         */
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                /*
                 * 用双指针判出有环之后，相遇点和头结点分别next，再相遇就是入环点
                 * 这个事数学上好证明，画个图也好理解，反正干想不太能理解
                 */
                ListNode meet = fast;
                while (true) {
                    if (head == meet) {
                        return meet;
                    }
                    head = head.next;
                    meet = meet.next;
                }
            }
        }

        return null;
        /* 时间O(n)空间O(1) */
    }
}
