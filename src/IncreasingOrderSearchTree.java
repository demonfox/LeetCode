// Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of 
// the tree, and every node has no left child and only one right child.

public class IncreasingOrderSearchTree {
  public TreeNode increasingBST(TreeNode root) {
    if (root == null) return null;
    TreeNode head = increasingBST(root.left);
    TreeNode temp = head;
    if (temp != null) {
      while (temp.right != null)
        temp = temp.right;
      temp.right = root;
    } else
      head = temp = root;
    root.left = null;
    root.right = increasingBST(root.right);
    return head;
  }

  public static void Run() {
    IncreasingOrderSearchTree ios = new IncreasingOrderSearchTree();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.right = new TreeNode(9);
    TreeNode res = ios.increasingBST(root);
    while (res != null) {
      System.out.print(res.val + " ");
      res = res.right;
    }
    System.out.println();

    root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(7);
    res = ios.increasingBST(root);
    while (res != null) {
      System.out.print(res.val + " ");
      res = res.right;
    }
    System.out.println();

    root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.right = new TreeNode(9);
    res = ios.increasingBST(root);
    while (res != null) {
      System.out.print(res.val + " ");
      res = res.right;
    }
  }
}
