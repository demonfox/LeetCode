// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
// (i.e., from left to right, then right to left for the next level and alternate between).

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if (root == null)
      return result;
    Deque<TreeNode> q  = new LinkedList<TreeNode>();
    q.add(root);
    boolean leftToRight = true;
    while (!q.isEmpty()) {
      int nodeOnCurrLevel = q.size();
      List<Integer> currLevelNodes = new LinkedList<Integer>();
      while (nodeOnCurrLevel-- != 0) {
        TreeNode n = leftToRight ? q.removeFirst() : q.removeLast();
        currLevelNodes.add(n.val);
        if (leftToRight) {
          if (n.left != null)
            q.addLast(n.left);
          if (n.right != null)
            q.addLast(n.right);
        } else {
          if (n.right != null)
            q.addFirst(n.right);
          if (n.left != null)
            q.addFirst(n.left);
        }
      }
      result.add(currLevelNodes);
      leftToRight = !leftToRight;
    }
    return result;
  }

  public static void Run() {
    BinaryTreeZigzagLevelOrderTraversal t = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(12);
        TreeNode n5 = new TreeNode(15);
        TreeNode n6 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        List<List<Integer>> result = t.zigzagLevelOrder(n1);
        for(List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
  }
}
