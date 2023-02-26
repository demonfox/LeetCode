// Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), 
// construct the tree and return its root.
// It is guaranteed that there is always possible to find a binary search tree with the given requirements for the 
// given test cases.
// A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less 
// than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
// A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses 
// Node.right.

import java.util.ArrayList;

public class BSTfromPre {
  public TreeNode bstFromPreorder2(int[] preorder) {
    if (preorder.length == 0)
      return null;
    
    ArrayList<Integer> leftSubtree = new ArrayList<Integer>();
    ArrayList<Integer> rightSubtree = new ArrayList<Integer>();

    TreeNode root = new TreeNode(preorder[0]);
    for (int i=1; i<preorder.length; i++) {
      if (preorder[i] < root.val)
        leftSubtree.add(preorder[i]);
      else if(preorder[i] > root.val)
        rightSubtree.add(preorder[i]);
    }
    root.left = bstFromPreorder(leftSubtree.stream().mapToInt(i->i).toArray());
    root.right = bstFromPreorder(rightSubtree.stream().mapToInt(i->i).toArray());

    return root;
  }

  private int index;
  private int[] preorder;

  public TreeNode bstFromPreorder(int[] preorder) {
    index = 0;
    this.preorder = preorder;
    return buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  // 2022.2.26: I am a little tired so I will mostly just finish the algorithm but leave much to be commented
  // on a later day. But this is a beauty if you really think about it. The time complexity is O(N) rather than
  // O(NlogN) for the recursive approach
  private TreeNode buildTree(int low, int high) {
    if (index == preorder.length) // means we have reached the end of the array
      return null;
    
    if (preorder[index] < low || preorder[index] > high) // means this is not the right place for this node element
      return null;

    TreeNode currNode = new TreeNode(preorder[index]);
    // The value range of left subtree is within this bound, let's traverse there to find a place for the next element
    // in the array. we may not find the right position for the next element there, which means we could then backtrace 
    // (see the if block right above), but the whole idea is the find a right location for the next element inside this
    // BST structure
    currNode.left = buildTree(low, currNode.val); 
    currNode.right = buildTree(currNode.val, high);

    return currNode;
  }

  public static void Run() {
    BSTfromPre b = new BSTfromPre();
    b.bstFromPreorder(new int[]{8,5,1,7,10,12});
  }
}
