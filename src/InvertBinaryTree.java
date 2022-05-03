// Given the root of a binary tree, invert the tree, and return its root.

public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    invertTree(root.left);
    invertTree(root.right);
    TreeNode node = root.left;
    root.left = root.right;
    root.right = node;
    return root;
  }

  public static void printTree(TreeNode root) {
    PrintBinaryTree p = new PrintBinaryTree();
    PrintBinaryTree.printTree(p.printTree(root));
  }

  public static void Run() {
    InvertBinaryTree i = new InvertBinaryTree();
    TreeNode n1 = new TreeNode(4);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(7);
    TreeNode n4 = new TreeNode(1);
    TreeNode n5 = new TreeNode(3);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(9);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    
    i.invertTree(n1);
    printTree(n1);
  }
}
