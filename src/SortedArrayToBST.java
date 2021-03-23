// Given an integer array nums where the elements are sorted in ascending order, convert it to a 
// height-balanced binary search tree.
// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every 
// node never differs by more than one.

public class SortedArrayToBST {
  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length-1);
  }

  private TreeNode helper(int[] nums, int start, int end) {
    TreeNode currRoot;
    if (start == end) {
      currRoot = new TreeNode(nums[start]);
    } else if (start > end) {
      currRoot = null;
    } else {
      int m = start + (end-start)/2;
      currRoot = new TreeNode(nums[m]);
      currRoot.left = helper(nums, start, m-1);
      currRoot.right = helper(nums, m+1, end);
    }
    return currRoot;
  }

  public static void printTree(TreeNode root) {
    PrintBinaryTree p = new PrintBinaryTree();
    PrintBinaryTree.printTree(p.printTree(root));
  }

  public static void Run() {
    SortedArrayToBST s = new SortedArrayToBST();
    TreeNode root = s.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    printTree(root);
    root = s.sortedArrayToBST(new int[]{1,3});
    printTree(root);
  }
}
