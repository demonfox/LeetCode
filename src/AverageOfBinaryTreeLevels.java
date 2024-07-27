// Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 
// Answers within 10-5 of the actual answer will be accepted.

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfBinaryTreeLevels {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new LinkedList<>();
    Queue<TreeNode> q1 = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();
    q1.add(root);
    while(!q1.isEmpty() || !q2.isEmpty()) {
      double sum = 0;
      int count = 0;
      while (!q1.isEmpty()) {
        TreeNode currNode = q1.poll();
        sum += currNode.val;
        count++;
        if (currNode.left != null)
          q2.add(currNode.left);
        if (currNode.right != null)
          q2.add(currNode.right);
      }
      result.add((double)sum / count);
      Queue<TreeNode> temp = q1;
      q1 = q2;
      q2 = temp;
    }
    return result;
  }

  public static void Run() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    AverageOfBinaryTreeLevels test = new AverageOfBinaryTreeLevels();
    List<Double> result = test.averageOfLevels(root);
    System.out.println(result);

    // generate a tree with INT_MAX values
    root = new TreeNode(Integer.MAX_VALUE);
    root.left = new TreeNode(Integer.MAX_VALUE);
    root.right = new TreeNode(Integer.MAX_VALUE);
    result = test.averageOfLevels(root);
    System.out.println(result);
  }
}
