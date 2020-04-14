/*
 * Author: Andliage Pox
 * Date: 2020-04-14
 */

package leetcode.cci;

import leetcode.Util;
import leetcode.ds.TreeNode;

public class CCI_04_02 {
    public static void main(String[] args) {
        TreeNode root = new CCI_04_02().sortedArrayToBST(new int[]{1, 2, 5, 6, 8});
        Util.printTree(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);

        return root;
    }
}
