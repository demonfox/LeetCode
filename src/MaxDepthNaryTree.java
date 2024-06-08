// Given a n-ary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthNaryTree {
  public class Node {
    public int val;
    public List<Node> children;
  
    public Node() {}
  
    public Node(int _val) {
        val = _val;
    }
  
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
  }

  public int maxDepth1(Node root) {
    if (root == null) return 0;

    Queue<Node> queue = new LinkedList<>();
    int depth = 0;
    root.val = 1;
    queue.add(root);
    while(!queue.isEmpty()) {
      Node curr = queue.poll();
      depth = Math.max(depth, curr.val);
      if (curr.children == null)
        continue;
      for (Node n : curr.children) {
        n.val = curr.val + 1;
        queue.add(n);
      }
    }
    return depth;
  }

  public int maxDepth(Node root) {
    if (root == null) return 0;
    int max = 0;
    if (root.children != null) {
      for (Node n : root.children) {
        max = Math.max(max, maxDepth(n));
      }
    }
    return max + 1;
  }

  public static void Run() {
    MaxDepthNaryTree m = new MaxDepthNaryTree();
    // generate a test case with this tree (1 (3 (5, 6), 2, 4))
    Node n1 = m.new Node(1);
    Node n2 = m.new Node(2);
    Node n3 = m.new Node(3);
    Node n4 = m.new Node(4);
    Node n5 = m.new Node(5);
    Node n6 = m.new Node(6);
    n1.children = List.of(n3, n2, n4);
    n3.children = List.of(n5, n6);
    System.out.println(m.maxDepth(n1));
    System.out.println(m.maxDepth1(n1));
  }
}
