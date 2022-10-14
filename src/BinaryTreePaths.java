// Given the root of a binary tree, return all root-to-leaf paths in any order.
// A leaf is a node with no children.

import java.util.*;

public class BinaryTreePaths {
  private void helper(TreeNode node, String path, List<String> result) {
    path += Integer.toString(node.val);
    boolean leftIsNull = false, rightIsNull = false;
    
    if (node.left != null) {
      String lPath = new String(path + "->");
      helper(node.left, lPath, result);
    } else {
      leftIsNull = true;
    }

    if (node.right != null) {
      String rPath = new String(path + "->");
      helper(node.right, rPath, result);
    } else {
      rightIsNull = true;
    }

    if (leftIsNull && rightIsNull) {
      result.add(path);
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null)
      return result;

    helper(root, "", result);
    return result;
  }

  public static void Run() {
    BinaryTreePaths b = new BinaryTreePaths();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(5);
    TreeNode n5 = new TreeNode(6);
    n1.left = n2;
    n1.right = n3;
    //n2.right = n4;
    n3.left = n4;
    n3.right = n5;

    List<String> result = b.binaryTreePaths(n1);
    result.forEach(s -> System.out.println(s));
  }
}
