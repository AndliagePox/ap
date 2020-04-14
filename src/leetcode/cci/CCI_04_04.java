/*
 * Author: Andliage Pox
 * Date: 2020-04-14
 */

package leetcode.cci;

import leetcode.ds.TreeNode;

import java.util.HashMap;

public class CCI_04_04 {
    private boolean balance = true;
    private HashMap<TreeNode, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new CCI_04_04().isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        Integer lh = height(root.left);
        Integer rh = height(root.right);
        if (Math.abs(lh - rh) > 1) {
            balance = false;
        }

        if (!balance) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private Integer height(TreeNode root) {
        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);

        Integer h = Math.max(height(root.left), height(root.right)) + 1;
        map.put(root, h);
        return h;
    }
}
