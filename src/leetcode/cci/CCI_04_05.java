/*
 * Author: Andliage Pox
 * Date: 2020-04-19
 */

package leetcode.cci;

import leetcode.ds.TreeNode;

import java.util.LinkedList;

public class CCI_04_05 {
    private boolean endFlag = false;
    private LinkedList<TreeNode> inOrderList = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new CCI_04_05().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        /*
         * 好久没写注释了，面向测试用例编程不可取啊
         * 不过这波链表用的很强
         */
        buildList(root);
        return !endFlag;
    }

    private void buildList(TreeNode root) {
        if (root == null || endFlag) return;

        buildList(root.left);
        if (!inOrderList.isEmpty() && root.val <= inOrderList.peekLast().val) {
            endFlag = true;
            return;
        }
        inOrderList.add(root);
        buildList(root.right);
    }
}
