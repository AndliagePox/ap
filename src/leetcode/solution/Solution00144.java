/*
 * Author: Andliage Pox
 * Date: 2020-02-02
 */

package leetcode.solution;

import leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution00144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> list = new Solution00144().preorderTraversal(root);
        for(Integer i: list) {
            System.out.println(i);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        /*
         * 迭代二叉树前序遍历，好像不是特别复杂的样子
         */
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;

        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.empty()) {
            temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return list;
        /* 时间O(n)空间O(n) */
    }
}
