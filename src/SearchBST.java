// You are given the root of a binary search tree (BST) and an integer val.
// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a 
// node does not exist, return null.


public class SearchBST {
  public TreeNode searchBST(TreeNode root, int val) {
    TreeNode result = null;
    result = helper(root, val);
    return result;
  }

  private TreeNode helper(TreeNode root, int val) {
    if (root == null)
      return null;
    if (root.val == val)
      return root;
    if (root.val > val)
      return helper(root.left, val);
    else
      return helper(root.right, val);
  }

  public static void Run() {
    SearchBST s = new SearchBST();
    TreeNode n1 = new TreeNode(4);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(7);
    TreeNode n4 = new TreeNode(1);
    TreeNode n5 = new TreeNode(3);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    TreeNode result = s.searchBST(n1, 2);
    System.out.println(result.val);

    result = s.searchBST(n1, 5);
    System.out.println(result == null);
  }
}
