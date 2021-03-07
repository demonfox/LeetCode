// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest 
// path from the root node down to the nearest leaf node.
// Note: A leaf is a node with no children.

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMinDepth {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return 0;
        q.add(root);
        int minDepth = 1;
        while(!q.isEmpty()) {
            int nodesOnCurrLevel = q.size();
            while (nodesOnCurrLevel-- != 0) {
                TreeNode currNode = q.remove();
                if (currNode.left == null && currNode.right == null)
                    return minDepth;
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
            minDepth++;
        }
        return 1; // function has to return a value
    }

    public static void Run() {
        BinaryTreeMinDepth t = new BinaryTreeMinDepth();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(t.minDepth(n1));
        System.out.println(t.minDepth(null));
    }
}
