public class SumRootToLeafBinaryNums {
  private int result = 0;
  public int sumRootToLeaf(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    helper(root, sb);
    return result;
  }

  private void helper(TreeNode node, StringBuilder sb) {
    if (node == null)
      return;
    if (node.left == null && node.right == null) {
      sb.append(node.val);
      result += Integer.parseInt(sb.toString(), 2);
      sb.deleteCharAt(sb.length()-1);
      return;
    }
    sb.append(node.val);
    helper(node.left, sb);
    helper(node.right, sb);
    sb.deleteCharAt(sb.length()-1);
  }

  public static void Run() {
    SumRootToLeafBinaryNums s = new SumRootToLeafBinaryNums();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);
    System.out.println(s.sumRootToLeaf(root));
  }
}
