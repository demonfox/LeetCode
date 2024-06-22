// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with
// the same structure and node values of subRoot and false otherwise.
// A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's 
// descendants. The tree tree could also be considered as a subtree of itself.

public class SubtreeOfTree {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null || subRoot == null) return false;
    
    if (root.val == subRoot.val) {
      if (isIdenticalTree(root, subRoot))
        return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isIdenticalTree(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
      return true;
    if(t1 != null && t2 != null && t1.val == t2.val)
      return isIdenticalTree(t1.left, t2.left) && isIdenticalTree(t1.right, t2.right);
    return false;
  }

  public static void Run() {
    // generate a test case for isSubtree
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(5);
    root.left = left;
    root.right = right;
    left.left = new TreeNode(1);
    left.right = new TreeNode(2);

    TreeNode subRoot = new TreeNode(4);
    subRoot.left = new TreeNode(1);
    subRoot.right = new TreeNode(2);

    System.out.println(new SubtreeOfTree().isSubtree(root, subRoot));

    left.right.left = new TreeNode(0);

    System.out.println(new SubtreeOfTree().isSubtree(root, subRoot));
  }
}
