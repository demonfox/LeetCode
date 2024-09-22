// Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n 
// nodes of unique values from 1 to n. Return the answer in any order.

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees(int n) {
    return helper(1, n);
  }
  
  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> list = new LinkedList<>();
    if (start > end) {
      list.add(null);
      return list;
    }

    for (int i=start; i<=end; i++) {
      List<TreeNode> left = helper(start, i-1);
      List<TreeNode> right = helper(i+1, end);
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;
          list.add(root);
        }
      }
    }
    return list;
  }

  public static void printTree(TreeNode root) {
    PrintBinaryTree p = new PrintBinaryTree();
    PrintBinaryTree.printTree(p.printTree(root));
  }

  public static void main(String[] args) {
    UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
    List<TreeNode> list = solution.generateTrees(3);
    for (TreeNode root : list) {
      printTree(root);
      System.out.println();
    }
  }
}
