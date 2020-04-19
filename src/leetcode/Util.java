/*
 * Author: Andliage Pox
 * Date: 2020-01-31
 */

package leetcode;

import leetcode.ds.ListNode;
import leetcode.ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    public static TreeNode buildTree(String s) {
        s = s.replace(" ", "");
        String[] nodeStrs = s.split(",");
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(nodeStrs));
        Deque<TreeNode> building = new ArrayDeque<>();
        if (nodes.isEmpty()) return null;

        String rootStr = nodes.pollFirst();
        if (rootStr == null || rootStr.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(rootStr));

        building.add(root);
        while (!building.isEmpty()) {
            TreeNode curNode = building.pollFirst();
            if (curNode == null) continue;

            String leftStr = nodes.pollFirst();
            if (leftStr == null || leftStr.equals("null")) {
                curNode.left = null;
            } else {
                building.add(curNode.left = new TreeNode(Integer.valueOf(leftStr)));
            }

            String rightStr = nodes.pollFirst();
            if (rightStr == null || rightStr.equals("null")) {
                curNode.right = null;
            } else {
                building.add(curNode.right = new TreeNode(Integer.valueOf(rightStr)));
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
