// Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two 
// different nodes in the tree.
public class MinDistanceBetweenBSTNodes {
  public int result = Integer.MAX_VALUE;
  private TreeNode prev = null;

  public int minDiffInBST(TreeNode root) {
    helper(root);
    return result;
  }

  private boolean helper(TreeNode root) {
    if (root == null)
      return false;

    if (helper(root.left)) 
      return true;

    if (prev != null) {
      int diff = Math.abs(root.val - prev.val);
      if (diff < result) {
        result = diff;
        if (result == 1)
          return true;
      }
    }
    prev = root;

    if (helper(root.right)) 
      return true;

    return false;
  }

  public static void Run() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(6);

    MinDistanceBetweenBSTNodes solution = new MinDistanceBetweenBSTNodes();
    System.out.println(solution.minDiffInBST(root));

    root = new TreeNode(0);
    root.left = new TreeNode(10);
    root.right = new TreeNode(48);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(50);

    solution.result = Integer.MAX_VALUE;
    System.out.println(solution.minDiffInBST(root));
  }
}
