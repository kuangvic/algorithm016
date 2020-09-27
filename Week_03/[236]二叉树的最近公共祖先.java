/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode lson = lowestCommonAncestor(root.left, p, q);
        TreeNode rson = lowestCommonAncestor(root.right, p, q);
        if (lson != null && rson != null) return root;
        return lson != null ? lson : rson;
    }
}