/*
 * Author: Andliage Pox
 * Date: 2020-04-19
 */

package leetcode.cci;

import leetcode.ds.TreeNode;

public class CCI_04_06 {
    private boolean endFlag = false;
    private boolean nextFlag = false;
    private TreeNode next = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);
        System.out.println(new CCI_04_06().inorderSuccessor(root, root.left).val);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        search(root, p);
        return next;
    }

    private void search(TreeNode root, TreeNode p) {
        if (root == null || endFlag) return;

        search(root.left, p);
        if (nextFlag) {
            endFlag = true;
            next = root;
            nextFlag = false;
            return;
        }
        if (root == p) {
            nextFlag = true;
        }
        search(root.right, p);
    }
}
