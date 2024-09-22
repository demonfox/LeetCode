// You are given the root of a binary tree containing digits from 0 to 9 only.
// Each root-to-leaf path in the tree represents a number.
// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
// Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit 
// in a 32-bit integer.
// A leaf node is a node with no children.

public class RootToLeafSum {
  private int result;
  public int sumNumbers(TreeNode root) {
    result = 0;
    helper(root, 0);
    return result;
  }

  private void helper(TreeNode curr, int currSum) {
    if (curr.left == null && curr.right == null) {
      result += currSum * 10 + curr.val;
      return;
    }

    if (curr.left != null) {
      helper(curr.left, currSum * 10 + curr.val);
    }

    if (curr.right != null) {
      helper(curr.right, currSum * 10 + curr.val);
    }
  }

  public static void Run() {
    RootToLeafSum r = new RootToLeafSum();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(r.sumNumbers(root));

    root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);
    System.out.println(r.sumNumbers(root));
  }
}
