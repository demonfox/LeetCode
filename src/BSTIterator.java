// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
// BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. 
// The pointer should be initialized to a non-existent number smaller than any element in the BST.
// boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
// int next() Moves the pointer to the right, then returns the number at the pointer.
// Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest 
// element in the BST.
// You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal 
// when next() is called.

import java.util.LinkedList;

public class BSTIterator {
  LinkedList<Integer> vals = new LinkedList<>();
  public BSTIterator(TreeNode root) {
    helper(root);
  }
  
  private void helper(TreeNode root) {
    if (root.left != null)
      helper(root.left);
    vals.add(root.val);
    if (root.right != null)
      helper(root.right);
  }

  public int next() {
    return vals.removeFirst();
  }
  
  public boolean hasNext() {
    return !vals.isEmpty();
  }

  public static void Run() {
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(20);
    BSTIterator iterator = new BSTIterator(root);
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
  }
}
