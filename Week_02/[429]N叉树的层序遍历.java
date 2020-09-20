/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // recursive + level DFS
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return result;
        recursive(root, 0);
        return result;
    }

    void recursive(Node node, int level) {
        // process
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            // drill down
            recursive(child, level + 1);
        }
    }
}