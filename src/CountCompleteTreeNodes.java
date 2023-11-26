// Given the root of a complete binary tree, return the number of the nodes in the tree.
// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, 
// and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// Design an algorithm that runs in less than O(n) time complexity.

public class CountCompleteTreeNodes {
  private int height(TreeNode root) {
    if (null == root) return 0;
    return 1 + height(root.left);
  }
  public int countNodes(TreeNode root) {
    if (null == root) return 0;
    int l = height(root.left);
    int r = height(root.right);
    if (l == r) {
      return (1 << l) + countNodes(root.right);
    } else {
      return (1 << (l-1)) + countNodes(root.left);
    }
  }

  public static void Run() {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    
    CountCompleteTreeNodes c = new CountCompleteTreeNodes();
    System.out.println(c.countNodes(n1));
  }
}
