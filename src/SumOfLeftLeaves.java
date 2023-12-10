// Given the root of a binary tree, return the sum of all left leaves.
// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

public class SumOfLeftLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    return helper(root, false);
  }

  public int helper(TreeNode root, boolean isLeftChild) {
    if (root == null) return 0;
    if (root.left == null && root.right == null && isLeftChild)
      return root.val + helper(root.left, true) + helper(root.right, false);
    else
      return helper(root.left, true) + helper(root.right, false);
  }

  public static void Run() {
    SumOfLeftLeaves s = new SumOfLeftLeaves();
    TreeNode n1 = new TreeNode(3);
    TreeNode n2 = new TreeNode(9);
    TreeNode n3 = new TreeNode(20);
    TreeNode n4 = new TreeNode(15);
    TreeNode n5 = new TreeNode(7);
    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n3.right = n5;
    System.out.println(s.sumOfLeftLeaves(n1));
    TreeNode n6 = new TreeNode(17);
    n3.left = n6;
    System.out.println(s.sumOfLeftLeaves(n1));
  }
}
