// The thief has found himself a new place for his thievery again. There is only one entrance to this 
// area, called root.
// Besides the root, each house has one and only one parent house. After a tour, the smart thief 
// realized that all houses in this place form a binary tree. It will automatically contact the police 
// if two directly-linked houses were broken into on the same night.
// Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

import javafx.util.Pair;

public class HouseRobberIII {
  public int rob(TreeNode root) {
    Pair<Integer, Integer> vals = dfs(root);
    return Math.max(vals.getKey(), vals.getValue());
  }

  // return a pair of value: [withRoot, withoutRoot]
  private Pair<Integer, Integer> dfs(TreeNode node) {
    if (node == null)
      return new Pair<Integer,Integer>(0, 0);
    Pair<Integer, Integer> leftTreeVals = dfs(node.left);
    Pair<Integer, Integer> rightTreeVals = dfs(node.right);

    // since we are taking the root, then we cannot take leftTree's root. In other words, we cannot
    // take the value of leftTreeWithRoot, and we have to take the value of leftTreeWithoutRoot
    int withRoot = node.val + leftTreeVals.getValue() + rightTreeVals.getValue();
    int withoutRoot = Math.max(leftTreeVals.getKey(), leftTreeVals.getValue()) + Math.max(rightTreeVals.getKey(), rightTreeVals.getValue());

    return new Pair<Integer,Integer>(withRoot, withoutRoot);
  }

  public static void Run() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(1);
    System.out.println(new HouseRobberIII().rob(root));

    root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(1);
    System.out.println(new HouseRobberIII().rob(root));
  }
}
