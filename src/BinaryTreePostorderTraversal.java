// Given the root of a binary tree, return the postorder traversal of its nodes' values.

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    recursion(result, root);
    return result;
  }

  private void recursion(List<Integer> list, TreeNode root) {
    if (root == null) return;
    recursion(list, root.left);
    recursion(list, root.right);
    list.add(root.val);
  }

  public static void Run() {
    BinaryTreePostorderTraversal b = new BinaryTreePostorderTraversal();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    n1.right = n2;
    n2.left = n3;
    List<Integer> list = b.postorderTraversal(n1);
    System.out.println(list.toString());
    list.forEach(System.out::println);
  }
}
