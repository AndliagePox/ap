/*
 * Author: Andliage Pox
 * Date: 2020-01-18
 */

package leetcode;

public class Solution00100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(new Solution00100().isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
         * 再整个递归判断相同树凑数
         */
        if (p == null || q == null) {
            // 唯一有趣的就是这里了，如果你俩有一个null，那就得俩null才可以true，否则false
            return p == null && q == null;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
