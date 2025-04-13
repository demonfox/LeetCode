// A binary tree is uni-valued if every node in the tree has the same value.
// Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {
  public boolean isUnivalTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode curr = q.poll();
      if (curr.val != root.val)
        return false;
      if (curr.left != null)
        q.add(curr.left);
      if (curr.right != null)
        q.add(curr.right);
    }
    return true;
  }

  public static void Run() {
    UnivaluedBinaryTree u = new UnivaluedBinaryTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(2);
    root.right.right = new TreeNode(1);
    System.out.println(u.isUnivalTree(root));
  }
}
