// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    if (root == null)
      return result;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while (!q.isEmpty()) {
      int nodesOnCurrLevel = q.size();
      List<Integer> currLevelNodes = new LinkedList<Integer>();
      while (nodesOnCurrLevel-- > 0) {
        TreeNode node = q.remove();
        currLevelNodes.add(node.val);
        if (node.left != null)
          q.add(node.left);
        if (node.right != null)
          q.add(node.right);
      }
      result.addFirst(currLevelNodes);
    }
    return result;
  }

  public static void Run() {
    BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
    TreeNode n1 = new TreeNode(3);
    TreeNode n2 = new TreeNode(9);
    TreeNode n3 = new TreeNode(20);
    TreeNode n4 = new TreeNode(15);
    TreeNode n5 = new TreeNode(7);
    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n3.right = n5;
    List<List<Integer>> result = b.levelOrderBottom(n1);
    for (List<Integer> l : result) {
      l.forEach(i -> System.out.print(i + " "));
      System.out.println();
    }
  }
}
