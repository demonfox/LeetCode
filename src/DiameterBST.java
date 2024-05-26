// Given the root of a binary tree, return the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or 
// may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.

public class DiameterBST {
  private int result = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    helper(root);
    return result;
  }

  private int helper(TreeNode curr) {
    if (curr == null)
      return -1;
    int leftDiameter = helper(curr.left);
    int rightDiameter = helper(curr.right);
    result = Math.max(result, leftDiameter + rightDiameter + 2);
    return Math.max(leftDiameter + 1, rightDiameter + 1);
  }

  public static void Run() {
    // generate a test case for DiameterBST with this tree (1 (2 (4, 5), 3))
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    DiameterBST test = new DiameterBST();
    int result = test.diameterOfBinaryTree(root);
    System.out.println(result);

    // generate another test case with this tree (1 (2 (4, 5), 3 (6, 7)))
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    result = test.diameterOfBinaryTree(root);
    System.out.println(result);
  }
}
