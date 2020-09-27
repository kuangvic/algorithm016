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
    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length, inLen = inorder.length;
        if (preLen != inLen) throw new IllegalArgumentException("argument wrong!");

        for (int i = 0; i < inLen; i++) cache.put(inorder[i], i);
        return buildSub(preorder, 0, preLen - 1, 0, preLen - 1);
    }

    TreeNode buildSub (int[] preorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;

        int inorder_root = cache.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = buildSub(preorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = buildSub(preorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}