// Given a binary tree, determine if it is height-balanced.
// For this problem, a height-balanced binary tree is defined as:
// a binary tree in which the left and right subtrees of every node differ in 
// height by no more than 1.

public class BalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    return isBalancedHelper(root) != -1;
  }

  // return the depth of the node if it is a balanced subtree; -1 otherwise
  private int isBalancedHelper(TreeNode node) {
    if (node.left == null && node.right == null) {
      return 1;
    }
    
    int leftSubTreeDepth, rightSubTreeDepth;
    leftSubTreeDepth = rightSubTreeDepth = 0;

    if (node.left != null) {
      leftSubTreeDepth = isBalancedHelper(node.left);
      if (leftSubTreeDepth == -1)
        return -1;
    } else {
      leftSubTreeDepth = 0;
    }
    if (node.right != null) {
      rightSubTreeDepth = isBalancedHelper(node.right);
      if (rightSubTreeDepth == -1)
        return -1;
    } else {
      rightSubTreeDepth = 0;
    }

    if (Math.abs(leftSubTreeDepth - rightSubTreeDepth) > 1)
      return -1;
    return Math.max(leftSubTreeDepth, rightSubTreeDepth) + 1;
  }

  public static void Run() {
    BalancedBinaryTree b = new BalancedBinaryTree();
    TreeNode n1 = new TreeNode(3);
    TreeNode n2 = new TreeNode(9);
    TreeNode n3 = new TreeNode(20);
    TreeNode n4 = new TreeNode(15);
    TreeNode n5 = new TreeNode(7);
    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n3.right = n5;
    System.out.println(b.isBalanced(n1));
    
    n1 = new TreeNode(1);
    n2 = new TreeNode(2);
    n3 = new TreeNode(2);
    n4 = new TreeNode(3);
    n5 = new TreeNode(3);
    TreeNode n6 = new TreeNode(4);
    TreeNode n7 = new TreeNode(4);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n4.left = n6;
    n4.right = n7;
    System.out.println(b.isBalanced(n1));
  }
}
