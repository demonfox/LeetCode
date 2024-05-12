import java.util.ArrayList;

public class MinDiffBST {
  private ArrayList<Integer> allNodes = new ArrayList<>();
  public int getMinimumDifference(TreeNode root) {
    // because this is a BST, InOrder traverse will traverse the entire tree in sorted order
    InOrderTraverse(root);
    int minDiff = Integer.MAX_VALUE;
    for (int i=1; i<allNodes.size(); i++)
      minDiff = Math.min(minDiff, allNodes.get(i) - allNodes.get(i-1));
    return minDiff;
  }

  private void InOrderTraverse(TreeNode root) {
    if (root == null) return;
    InOrderTraverse(root.left);
    allNodes.add(root.val);
    InOrderTraverse(root.right);
  }

  public static void Run() {
    // generate a test case with this tree: (4 (2 (1) (3)) (6 (5) (7)))
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    MinDiffBST minDiffBST = new MinDiffBST();
    System.out.println(minDiffBST.getMinimumDifference(root));

    // generate a test case with this tree: (7 (0) (48 (12) (59)))
    root = new TreeNode(7);
    root.left = new TreeNode(0);
    root.right = new TreeNode(48);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(59);
    minDiffBST = new MinDiffBST();
    System.out.println(minDiffBST.getMinimumDifference(root));
  }
}
