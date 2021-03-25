// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the 
// sequence has an edge connecting them. A node can only appear in the sequence at most once. 
// Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any path.

public class BinaryTreeMaxPathSum {
  private int result = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    result = Math.max(helper(root), result);
    return result;
  }

  private int helper(TreeNode root) {
    if (root == null)
      return 0;
    int leftSum = helper(root.left);
    int rightSum = helper(root.right);
    int subtreeSum = Math.max(leftSum, rightSum);
    if (leftSum > 0 && rightSum > 0)
      result = Math.max(leftSum + rightSum + root.val, result);
    else if (leftSum < 0 && rightSum < 0)
      result = Math.max(root.val, result);
    else
      result = Math.max(subtreeSum+root.val, result);

    // return the max value we have achieve when traversing through the current node
    return root.val + Math.max(subtreeSum,0);
  }

  public static void Run() {
    BinaryTreeMaxPathSum b = new BinaryTreeMaxPathSum();
    TreeNode n1 = new TreeNode(-1);
    TreeNode n2 = new TreeNode(-2);
    TreeNode n3 = new TreeNode(10);
    // TreeNode n1 = new TreeNode(1);
    // TreeNode n2 = new TreeNode(2);
    // TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(-6);
    //TreeNode n5 = new TreeNode(7);
    TreeNode n6 = new TreeNode(-3);
    TreeNode n7 = new TreeNode(-6);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = null;
    n3.left = n6;
    n3.right = n7;
    System.out.println(b.maxPathSum(n1));
  }
}
