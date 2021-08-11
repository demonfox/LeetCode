// Serialization is the process of converting a data structure or object into a sequence of 
// bits so that it can be stored in a file or memory buffer, or transmitted across a network 
// connection link to be reconstructed later in the same or another computer environment.
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on 
// how your serialization/deserialization algorithm should work. You just need to ensure that 
// a binary tree can be serialized to a string and this string can be deserialized to the original 
// tree structure.

import java.util.LinkedList;
import java.util.Queue;

public class CodecBT {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (null == root)
      return "";

    StringBuilder result = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while (!q.isEmpty()) {
      int nodesOnCurrLevel = q.size();
      boolean isLeafLevel = true;
      while (nodesOnCurrLevel-- != 0) {
        TreeNode node = q.remove();
        if (null != node) {
          result.append(node.val + ",");
          if (null != node.left) {
            q.add(node.left);
            isLeafLevel = false;
          }
          else
            q.add(null);
          if (node.right != null) {
            q.add(node.right);
            isLeafLevel = false;
          }
          else
            q.add(null);
        } else
          result.append("null,");          
      }
      if (isLeafLevel == true)
        q.clear();
    }
    result.deleteCharAt(result.length()-1);
    while (result.length() >=5 && result.substring(result.length()-5, result.length()).equals(",null"))
      result.delete(result.length()-5, result.length());
    return result.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    String[] input = data.split(",");
    TreeNode[] nodes = new TreeNode[input.length];
    nodes[0] = new TreeNode(Integer.parseInt(input[0]));
    int parentNodeIndex = 0;
    int nodesCollectionIndex = 1;
    boolean isLeftChild = true;

    for (int i=1; i<input.length; i++) {
      TreeNode node = null;
      if (!input[i].equals("null"))
        node = new TreeNode(Integer.parseInt(input[i]));
      
      if (node != null) {
        if (isLeftChild)
          nodes[parentNodeIndex].left = node;
        else
          nodes[parentNodeIndex].right = node;
        nodes[nodesCollectionIndex++] = node;
      }

      isLeftChild = !isLeftChild;
      if (isLeftChild)
        parentNodeIndex++;
    }
    
    return nodes[0];
  }

  public static void Run() {
    CodecBT c = new CodecBT();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n3.right = n5;
    n4.left = n6;
    n4.right = n7;
    System.out.println(c.serialize(n1));
    TreeNode root = c.deserialize("4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2");
    System.out.println(c.serialize(root));
  }
}
