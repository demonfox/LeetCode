// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the 
// inclusive range [low, high].


public class RangeSumBST {
  private int result = 0;
  
  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null)
      return 0;
    if (root.val < low)
      return rangeSumBST(root.right, low, high);
    if (root.val > high)
      return rangeSumBST(root.left, low, high);
    return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
  }

  public int rangeSumBST2(TreeNode root, int low, int high) {
    helper(root, low, high);
    return result;
  }

  void helper(TreeNode root, int l, int h) {
    if (root.left != null)
      helper(root.left, l, h);
    if (root.val >= l && root.val <= h)
      result += root.val;
    if (root.right != null)
      helper(root.right, l, h);
  }
  

  public static void Run() {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(18);
    RangeSumBST rs = new RangeSumBST();
    System.out.println(rs.rangeSumBST(root, 7, 15));
  }
}
