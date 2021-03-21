// You are given a perfect binary tree where all leaves are on the same level, and 
// every parent has two children. The binary tree has the following definition:
// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, 
// the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointerInTree {
  public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
  }

  public Node connect(Node root) {
    if (root == null)
      return null;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int nodesOnCurrLevel = q.size();
      Node prevNode = null;
      Node currNode = null;
      while (nodesOnCurrLevel-- > 0) {
        currNode = q.remove();
        if (prevNode != null) {
          prevNode.next = currNode;
        }
        currNode.next = null;
        prevNode = currNode;
        q.add(currNode.left); // since we are guaranteed a perfect binary tree, so no need to check for null
        q.add(currNode.right);
      }
    }
    return root;
  }

  public static void Run() {
    PopulateNextPointerInTree p = new PopulateNextPointerInTree();
    Node n1 = p.new Node(1);
    Node n2 = p.new Node(2);
    Node n3 = p.new Node(3);
    Node n4 = p.new Node(4);
    Node n5 = p.new Node(5);
    Node n6 = p.new Node(6);
    Node n7 = p.new Node(7);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.left = n7;
    p.connect(n1);
  }
}
