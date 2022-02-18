// Given the root of a binary tree, return the preorder traversal of its nodes' values.

import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class BinaryTreePreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<Integer>();
    if (root == null) return result;
    Deque<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      result.add(curr.val);
      if (curr.right != null)
        queue.addFirst(curr.right);
      if (curr.left != null)
        queue.addFirst(curr.left);
    }
    return result;
  }

  public static void Run() {
    BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(4);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(2);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    List<Integer> list = b.preorderTraversal(n1);
    System.out.println(list.toString());
    list.forEach(System.out::println);
  }
}
