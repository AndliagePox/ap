/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode;

import leetcode.ds.ListNode;
import leetcode.ds.TreeNode;

public abstract class Util {
    public static ListNode buildLinkedList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int t: nums) {
            temp.next = new ListNode(t);
            temp = temp.next;
        }
        return head.next;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
