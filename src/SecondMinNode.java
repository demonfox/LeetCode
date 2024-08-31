// Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly 
// two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More 
// formally, the property root.val = min(root.left.val, root.right.val) always holds.
// Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
// If no such second minimum value exists, output -1 instead.

public class SecondMinNode {
  int[] sentinel = new int[2];
  
  public int findSecondMinimumValue(TreeNode root) {
    sentinel[0] = sentinel[1] = root.val;
    traverse(root);
    return (sentinel[1] == sentinel[0]) ? -1 : sentinel[1];
  }

  private void traverse(TreeNode root) {
    if (root.left == null)
      return;
    if (root.left.val == root.right.val) {
      traverse(root.left);
      traverse(root.right);
    } else {
      if (root.left.val > root.right.val) {
        if (sentinel[1] == sentinel[0] || root.left.val < sentinel[1]) {
          sentinel[1] = root.left.val;
        }
        traverse(root.right);
      } else {
        if (sentinel[1] == sentinel[0] || root.right.val < sentinel[1]) {
          sentinel[1] = root.right.val;
        }
        traverse(root.left);
      }
    }
  }

  public static void Run() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    System.out.println(new SecondMinNode().findSecondMinimumValue(root));

    root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    System.out.println(new SecondMinNode().findSecondMinimumValue(root));
  }
}
