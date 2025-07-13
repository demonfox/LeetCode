// One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. 
// If it is a null node, we record using a sentinel value such as '#'.
// For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
// Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
// It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
// You may assume that the input format is always valid.
// For example, it could never contain two consecutive commas, such as "1,,3".
// Note: You are not allowed to reconstruct the tree.

import java.util.Stack;

public class VerifyPreorderSerBinaryTree {
  public boolean isValidSerialization(String preorder) {
    Stack<String> s = new Stack<>();
    String[] input = preorder.split(",");
    for (int i=0; i<input.length; i++) {
      if (!input[i].equals("#")) {
        s.add(input[i]);
      } else {
        while (!s.isEmpty() && s.peek().equals("#")) {
          s.pop();
          if (s.isEmpty())
            return false;
          s.pop();
        }
        s.add("#");
      }
    }
    return s.size() == 1 && s.peek().equals("#");  
  }

  public static void Run() {
    String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"; 
    VerifyPreorderSerBinaryTree vpsbt = new VerifyPreorderSerBinaryTree();
    System.out.println(vpsbt.isValidSerialization(preorder));
    preorder = "1,#,#,#,#";
    System.out.println(vpsbt.isValidSerialization(preorder));
  }
}
