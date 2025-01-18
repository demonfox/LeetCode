// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeafSimilarTrees {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> s = new Stack<>();
    Queue<Integer> q = new LinkedList<>();
    
    s.add(root1);
    while(!s.isEmpty()) { // this is essentially a DFS traversal
      TreeNode n = s.pop();
      if (n.left == null && n.right == null) {
        q.add(n.val);
      } else {
        if (n.right != null)
          s.add(n.right);
        if (n.left != null)
          s.add(n.left);
      }
    }

    s.add(root2);
    while(!s.isEmpty()) { // this is essentially a DFS traversal
      TreeNode n = s.pop();
      if (n.left == null && n.right == null) {
        if (q.isEmpty() || q.poll() != n.val)
          return false;
      } else {
        if (n.right != null)
          s.add(n.right);
        if (n.left != null)
          s.add(n.left);
      }
    }
    
    return q.isEmpty();
  }

  public static void Run() {
    LeafSimilarTrees l = new LeafSimilarTrees();
    TreeNode root1 = new TreeNode(3);
    root1.left = new TreeNode(5);
    root1.right = new TreeNode(1);
    root1.left.left = new TreeNode(6);
    root1.left.right = new TreeNode(2);
    root1.left.right.left = new TreeNode(7);
    root1.left.right.right = new TreeNode(4);
    root1.right.left = new TreeNode(9);
    root1.right.right = new TreeNode(8);

    TreeNode root2 = new TreeNode(3);
    root2.left = new TreeNode(5);
    root2.right = new TreeNode(1);
    root2.left.left = new TreeNode(6);
    root2.left.right = new TreeNode(7);
    root2.right.left = new TreeNode(4);
    root2.right.right = new TreeNode(2);
    root2.right.right.left = new TreeNode(9);
    root2.right.right.right = new TreeNode(8);
    System.out.println(l.leafSimilar(root1, root2));
  }
}
