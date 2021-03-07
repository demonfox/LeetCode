// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the 
// longest path from the root node down to the farthest leaf node.

public class BinaryTreeMaxDepth {
    private int maxDepth;
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        dfs(root, 1);
        return maxDepth;
    }
    
    private void dfs(TreeNode node, int d) {
        if (node == null) {
            maxDepth = Math.max(d - 1, maxDepth);
            return;
        }
        dfs(node.left, d+1);
        dfs(node.right, d+1);
    }

    public static void Run() {
        BinaryTreeMaxDepth t = new BinaryTreeMaxDepth();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(t.maxDepth(n1));
        System.out.println(t.maxDepth(null));
    }
}
