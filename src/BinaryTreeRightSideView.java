// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see 
// ordered from top to bottom.

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new LinkedList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new LinkedList<>();

    queue.add(root);
    int nodeCountOnLevel = 1;
    int nextLevelNodeCount = 1;
    while(!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      result.add(curr.val);
      nodeCountOnLevel = nextLevelNodeCount;
      nextLevelNodeCount = 0;
      while (true) {
        if (curr.right != null) {
          queue.add(curr.right);
          nextLevelNodeCount++;
        }
        if (curr.left != null) {
          queue.add(curr.left);
          nextLevelNodeCount++;
        }
        nodeCountOnLevel--;
        if (nodeCountOnLevel > 0)
          curr = queue.poll();
        else
          break;
      }
    }
    
    return result;
  }

  public static void Run() {
    BinaryTreeRightSideView bts = new BinaryTreeRightSideView();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    List<Integer> result = bts.rightSideView(root);
    System.out.println(result);

    root = new TreeNode(1);
    root.right = new TreeNode(3);
    result = bts.rightSideView(root);
    System.out.println(result);
  }
}
