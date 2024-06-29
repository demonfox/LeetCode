// Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

import java.util.LinkedList;
import java.util.List;

public class NaryTreePostorderTraversal {
  class Node {
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

  public List<Integer> postorder(Node root) {
    List<Integer> result = new LinkedList<>();
    if (root == null) return result;
    helper(root, result);
    return result;
  }

  private void helper(Node root, List<Integer> result) {
    if (root.children != null) {
      for (Node n : root.children)
        helper(n, result);
    }
    result.add(root.val);
  }

  public static void Run() {
    // generate a test case with tree [1,null,3,2,4,null,5,6] for postorder
    NaryTreePostorderTraversal n = new NaryTreePostorderTraversal();
    System.out.println(n.postorder(n.new Node(1, 
      List.of(n.new Node(3, 
      List.of(n.new Node(5), n.new Node(6))), 
      n.new Node(2), 
      n.new Node(4)))));

    // generate a test case with tree [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14] for postorder
    NaryTreePostorderTraversal n2 = new NaryTreePostorderTraversal();
    System.out.println(n2.postorder(n2.new Node(1, 
      List.of(n2.new Node(2), 
              n2.new Node(3, 
              List.of(n2.new Node(6), n2.new Node(7, 
              List.of(n2.new Node(11, 
              List.of(n2.new Node(14))))))),
              n2.new Node(4,
              List.of(n2.new Node(8,
              List.of(n2.new Node(12))))), 
              n2.new Node(5,
              List.of(n2.new Node(9,
              List.of(n2.new Node(13))), n2.new Node(10)))))));
  }
}
