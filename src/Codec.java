// Serialization is converting a data structure or object into a sequence of bits so that it 
// can be stored in a file or memory buffer, or transmitted across a network connection link 
// to be reconstructed later in the same or another computer environment.
// Design an algorithm to serialize and deserialize a binary search tree. There is no restriction 
// on how your serialization/deserialization algorithm should work. You need to ensure that a 
// binary search tree can be serialized to a string, and this string can be deserialized to the 
// original tree structure.
// The encoded string should be as compact as possible.

public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) return "";
    String result;
    result = Integer.toString(root.val) + "," + serialize(root.left) + serialize(root.right);
    return result;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    String[] input = data.split(",");
    return deserializeHelper(input, 0, input.length-1);
  }

  private TreeNode deserializeHelper(String[] input, int start, int end) {
    TreeNode node = new TreeNode(Integer.parseInt(input[start]));
    int leftSubtreeStart, leftSubtreeEnd, rightSubtreeStart, rightSubtreeEnd;
    leftSubtreeStart = leftSubtreeEnd = rightSubtreeStart = rightSubtreeEnd = -1;
    for (int i=start+1; i<=end; i++) {
      if (Integer.parseInt(input[i]) < Integer.parseInt(input[start])) {
        if (leftSubtreeStart == -1)
          leftSubtreeStart = leftSubtreeEnd =  i;
        else
          leftSubtreeEnd = i;
      } else {
        if (rightSubtreeStart == -1)
          rightSubtreeStart = rightSubtreeEnd = i;
        else
          rightSubtreeEnd = i;
      }
    }
    if (leftSubtreeStart != -1)
      node.left = deserializeHelper(input, leftSubtreeStart, leftSubtreeEnd);
    if (rightSubtreeStart != -1)
      node.right = deserializeHelper(input, rightSubtreeStart, rightSubtreeEnd);

    return node;
  }

  public static void Run() {
    Codec c = new Codec();
    TreeNode n1 = new TreeNode(10);
    TreeNode n2 = new TreeNode(5);
    TreeNode n3 = new TreeNode(12);
    TreeNode n4 = new TreeNode(1);
    TreeNode n5 = new TreeNode(6);
    TreeNode n6 = new TreeNode(11);
    TreeNode n7 = new TreeNode(13);
    TreeNode n8 = new TreeNode(15);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    n7.right = n8;
    String data = c.serialize(n1);
    System.out.println(data);
    TreeNode treeRecon = c.deserialize(data);
  }
}
