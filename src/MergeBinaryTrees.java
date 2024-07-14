// You are given two binary trees root1 and root2.
// Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others 
// are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum 
// node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
// Return the merged tree.
// Note: The merging process must start from the root nodes of both trees.

public class MergeBinaryTrees {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) return root2;
    if (root2 == null) return root1;
    
    helper(root1, root2);
    return root1;   
  }

  private void helper(TreeNode root1, TreeNode root2) {
    root1.val = root1.val + root2.val;

    if (root1.left != null && root2.left != null)
      helper(root1.left, root2.left);
    else if (root1.left == null && root2.left != null)
      root1.left = root2.left;

    if (root1.right != null && root2.right != null)
      helper(root1.right, root2.right);
    else if (root1.right == null && root2.right != null)
      root1.right = root2.right;
  }

  public static void printTree(TreeNode root) {
    PrintBinaryTree p = new PrintBinaryTree();
    PrintBinaryTree.printTree(p.printTree(root));
  }

  public static void Run() {
    // generate a tree root1 = [1,3,2,5]
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(3);
    root1.right = new TreeNode(2);
    root1.left.left = new TreeNode(5);

    // generate a tree root2 = [2,1,3,null,4,null,7]
    TreeNode root2 = new TreeNode(2);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(3);
    root2.left.right = new TreeNode(4);
    root2.right.right = new TreeNode(7);

    MergeBinaryTrees m = new MergeBinaryTrees();
    printTree(m.mergeTrees(root1, root2));
  }
}
