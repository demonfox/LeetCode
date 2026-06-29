// You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents 
// a binary number starting with the most significant bit.
// For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return 
// the sum of these numbers.
// The test cases are generated so that the answer fits in a 32-bits integer.

public class SumRootToLeafBinaryNums {
  private int result = 0;
  public int sumRootToLeaf(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    helper(root, sb);
    return result;
  }

  private void helper(TreeNode node, StringBuilder sb) {
    sb.append(node.val);
    if (node.left == null && node.right == null) {
      result += Integer.parseInt(sb.toString(), 2);
      sb.deleteCharAt(sb.length()-1);
      return;
    } else {
      if (node.left != null)
        helper(node.left, sb);
      if (node.right != null)
        helper(node.right, sb);
    }
    sb.deleteCharAt(sb.length()-1);
  }

  public static void Run() {
    SumRootToLeafBinaryNums s = new SumRootToLeafBinaryNums();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);
    System.out.println(s.sumRootToLeaf(root));
  }
}
