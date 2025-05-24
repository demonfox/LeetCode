// Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, 
// return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
// Two nodes of a binary tree are cousins if they have the same depth with different parents.
// Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the 
// depth k + 1.

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsBinaryTree {
  public boolean isCousins1(TreeNode root, int x, int y) {
    // since we know x & y exist in the tree and all node values are unique, let's
    // do some pruning
    if (root.val == x || root.val == y)
      // || (root.left != null && (root.left.val == x || root.left.val == y))
      // || (root.right != null && (root.right.val == x || root.right.val == y)))
      return false;
    List<Integer> list = new LinkedList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root.left != null) {
      q.add(root.left);
      list.add(1000000 + root.val * 1000 + root.left.val);
    }
    if (root.right != null) {
      q.add(root.right);
      list.add(1000000 + root.val * 1000 + root.right.val);
    }
    int depth = 2;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size > 0) {
        TreeNode curr = q.poll();
        if (curr.left != null) {
          list.add(depth * 1000000 + curr.val * 1000 + curr.left.val);
          q.add(curr.left);
        }
        if (curr.right != null) {
          list.add(depth * 1000000 + curr.val * 1000 + curr.right.val);
          q.add(curr.right);
        }
        size--;
      }
      depth++;
    }
    // PopulateList(root, list, 1);
    boolean firstValFound = false;
    int firstValDepth = -1;
    int firstValParent = 0;
    for (Integer i : list) {
      if (!firstValFound) {
        if (i % 1000 == x) {
          firstValFound = true;
          firstValDepth = i / 1000000;
          firstValParent = i / 1000;
        } else if (i % 1000 == y) {
          int temp = x;
          x = y;
          y = temp;
          firstValFound = true;
          firstValDepth = i / 1000000;
          firstValParent = i / 1000;
        }
      } else {
        if (i / 1000000 != firstValDepth)
          return false; // continue;
        else {
          if (i % 1000 == y) {
            if (i / 1000 == firstValParent)
              return false;
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean firstValFound = false;
  private int firstValDepth = -1;
  private int firstValParent = 0;
  private boolean foundCousin = false;
  public boolean isCousins(TreeNode root, int x, int y) {
    if (root.val == x || root.val == y)
      return false;
    firstValFound = false;
    firstValDepth = -1;
    firstValParent = 0;
    foundCousin = false;
    helper(root, x, y, 1);
    return foundCousin;
  }

  private void helper(TreeNode root, int x, int y, int depth) {
    if (root.left != null) {
      if (root.left.val == x || root.left.val == y) {
        if (!firstValFound) {
          firstValFound = true;
          firstValDepth = depth;
          firstValParent = root.val;
        } else {
          if (depth != firstValDepth || root.val == firstValParent) {
            foundCousin = false;
            return;
          }
          foundCousin = true;
          return;
        }
      }
      helper(root.left, x, y, depth + 1);
    }

    if (root.right != null) {
      if (root.right.val == x || root.right.val == y) {
        if (!firstValFound) {
          firstValFound = true;
          firstValDepth = depth;
          firstValParent = root.val;
        } else {
          if (depth != firstValDepth || root.val == firstValParent) {
            foundCousin = false;
            return;
          }
          foundCousin = true;
          return;
        }
      }
      helper(root.right, x, y, depth + 1);
    }
      
    // if (root.right != null)
    //   list.add(depth * 1000000 + root.val * 1000 + root.right.val);
    // if (root.left != null)
    //   PopulateList(root.left, list, depth + 1);
    // if (root.right != null)
    //   PopulateList(root.right, list, depth + 1);
  }

  public static void Run() {
    CousinsBinaryTree c = new CousinsBinaryTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(5);
    System.out.println(c.isCousins(root, 5, 4));

    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    System.out.println(c.isCousins(root, 2, 3));

    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.right.right = new TreeNode(6);
    root.left.left.left = new TreeNode(4);
    System.out.println(c.isCousins(root, 3, 6));
  }
}
