// Given the root of a binary tree, return the sum of every tree node's tilt.

// The tilt of a tree node is the absolute difference between the sum of all left subtree node values 
// and all right subtree node values. If a node does not have a left child, then the sum of the left 
// subtree node values is treated as 0. The rule is similar if the node does not have a right child.

public class BinaryTreeTilt {
  private int tilt = 0;

  public int findTilt(TreeNode root) {
    tilt = 0;
    fillTilt(root);
    return tilt;
  }
  public int fillTilt(TreeNode root) {
    if (root == null) return 0;

    int leftSum = fillTilt(root.left);
    int rightSum = fillTilt(root.right);
    int sum = leftSum + rightSum + root.val;
    tilt += Math.abs(leftSum - rightSum);
    return sum;
  }

  public static void Run() {
    BinaryTreeTilt btt = new BinaryTreeTilt();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(btt.findTilt(root));

    // generate a test case with this tree (4 (2, 9))
    // should be 15
    root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(9);
    System.out.println(btt.findTilt(root)); 
    
    // generate a test case with this tree (4 (2 (1, 1), 9 (8, 11)))
    // should be 134 (((2 (1, 1)) + (11 + 8)) - (1 + 8)) + (((9 (8, 11)) + (11 + 8)) - (1 + 8))
    root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(1);
    root.right = new TreeNode(9);
    root.right.left = new TreeNode(8);
    root.right.right = new TreeNode(11);
    System.out.println(btt.findTilt(root));

  }
}
