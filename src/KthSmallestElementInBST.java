// Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

public class KthSmallestElementInBST {
  public int counter = 0;
  
  public int kthSmallest(TreeNode root, int k) {
    if (root == null)
      return -1;

    int r = kthSmallest(root.left, k);
    if (r >= 0) // This is because the precondition stipulates that all node values are >= 0
      return r;
      
    counter++;
    if (counter == k) {
      return root.val;
    }

    return kthSmallest(root.right, k);
  }

  public static void Run() {
    KthSmallestElementInBST k = new KthSmallestElementInBST();
    TreeNode n1 = new TreeNode(3);
    TreeNode n2 = new TreeNode(1);
    TreeNode n3 = new TreeNode(4);
    TreeNode n4 = new TreeNode(2);
    n1.left = n2;
    n1.right = n3;
    n2.right = n4;
    System.out.println(k.kthSmallest(n1, 1));

    n1.val = 5;
    n2.val = 3;
    n3.val = 6;
    n4.val = 2;
    TreeNode n5 = new TreeNode(4);
    TreeNode n6 = new TreeNode(1);
    n2.left = n4;
    n2.right = n5;
    n4.left = n6;
    
    k.counter = 0;
    System.out.println(k.kthSmallest(n1, 3));
  }
}
