/*
 * Author: Andliage Pox
 * Date: 2020-01-16
 */

package leetcode;

public class Solution00002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(4);
        ListNode lr = new Solution00002().addTwoNumbers(l1, l2);
        while (lr != null) {
            System.out.print(lr.val);
            lr = lr.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         * 怕我不会输入都是逆序，那好说多了，一个一个加起来就好了
         * 要是其中一个链表加完了，就把剩的那个整个补在后面好了
         */
        boolean cIn = false; // 进位标记位
        ListNode result = new ListNode(0);
        ListNode tempListNode = result;
        int tempVal;

        while (cIn || (l1 != null && l2 != null)) {
            tempVal = 0;
            if (l1 != null) {
                tempVal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tempVal += l2.val;
                l2 = l2.next;
            }
            if (cIn) {
                tempVal++;
            }
            if (tempVal >= 10) {
                cIn = true;
                tempVal -= 10;
            } else {
                cIn = false;
            }
            tempListNode.next = new ListNode(tempVal);
            tempListNode = tempListNode.next;
        }

        if (l1 == null) {
            tempListNode.next = l2;
        } else {
            tempListNode.next = l1;
        }

        return result.next;
        /*
         * 时间空间O(n)
         * 当年用cpp提交居然用了30+ms，真是太有东西了
         * 看了一眼代码，问题应该出在用了太多的除法和取余
         * 所以上面改用判断和-10了，2ms还是不错的
         */
    }
}