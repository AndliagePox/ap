/*
 * Author: Andliage Pox
 * Date: 2020-01-18
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution00094 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> list = new Solution00094().inorderTraversal(root);
        for (Integer i: list) {
            System.out.print(i);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        /*
         * 闲来无事整个递归中序遍历二叉树凑数
         */
        List<Integer> list = new ArrayList<>();
        backtrack(list, root);
        return list;
    }

    private void backtrack(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        backtrack(list, root.left);
        list.add(root.val);
        backtrack(list, root.right);
    }
}
