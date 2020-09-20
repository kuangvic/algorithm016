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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        recursive(result, root);
        return result;
    }

    void recursive(List<Integer> result, TreeNode node) {
        result.add(node.val);
        if (node.left != null) recursive(result, node.left);
        if (node.right != null) recursive(result, node.right);
    }
}