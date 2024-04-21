// Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently 
// occurred element) in it.

// If the tree has more than one mode, return them in any order.

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindModeInBST {
  private HashMap<Integer, Integer> count = new HashMap<>();
  private int maxCount = 0;

  public int[] findMode(TreeNode root) {
    helper(root);

    List<Integer> result = new ArrayList<>();
    for (Integer key : count.keySet()) {
      if (count.get(key) == maxCount)
        result.add(key);
    }
    return result.stream().mapToInt(i->i).toArray();
  }

  private void helper(TreeNode node) {
    if (!count.containsKey(node.val)) {
      count.put(node.val, 1);
    } else {
      count.put(node.val, count.get(node.val) + 1);
    }
    maxCount = Math.max(maxCount, count.get(node.val));
    if (node.left != null)
      helper(node.left);
    if (node.right != null)
      helper(node.right);
  }

  public static void Run() {
    // generate test case for findMode
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(2);
    
    System.out.println("Modes are " + Arrays.toString((new FindModeInBST()).findMode(root)));

    // generate another test case for findMode
    root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    System.out.println("Modes are " + Arrays.toString((new FindModeInBST()).findMode(root)));
  }
}
