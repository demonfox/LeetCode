// Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same TreeNode class where the right 
// child pointer points to the next node in the list and the left child 
// pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal 
// of the binary tree.
public class BinaryTree2LinkedList {
  public void flatten(TreeNode root) {
    // check if there is a left child for curr
    // if there isn't, go to 4)
    // if there is, then
    // 1) find the right most child of the left subtree
    // 2) move the right subtree to be the child node of 1)
    // 3) move the left subtree to be the right child of curr
    // 4) nullify the left child of curr
    // 4) make recursive calls on the right child
    if (root == null)
      return;
    TreeNode curr = root;
    while (curr.right != null || curr.left != null) {
      if (curr.left != null) {
        TreeNode rightMostOnLeftSubTree = curr.left;
        while (rightMostOnLeftSubTree.right != null) {
          rightMostOnLeftSubTree = rightMostOnLeftSubTree.right;
        }
        rightMostOnLeftSubTree.right = curr.right;
        curr.right = curr.left;
        curr.left = null;
      }
      curr = curr.right;
    }
  }

  public static void print(TreeNode root) {
    while (root != null) {
      System.out.print(Integer.toString(root.val) + "->");
      root = root.right;
    }
    System.out.println("END");
  }
  public static void Run() {
    BinaryTree2LinkedList t = new BinaryTree2LinkedList();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(5);
    TreeNode n4 = new TreeNode(3);
    TreeNode n5 = new TreeNode(4);
    TreeNode n6 = new TreeNode(6);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.right = n6;
    t.flatten(n1);
    print(n1);
  }
}
