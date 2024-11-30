// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.
// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
// class Node {
//     public int val;
//     public List<Node> neighbors;
// }

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node) {
    if (node == null) return null;

    Queue<Node> queue = new LinkedList<>();
    HashMap<Node, Node> map = new HashMap<>();
    // int mask = 2; // starting with node.val = 1
    BitSet visited = new BitSet(101);

    Node result = new Node(node.val);
    map.put(node, result);

    queue.add(node);
    visited.set(1);
    while(!queue.isEmpty()) {
      Node curr = queue.poll();
      Node newCurr;
      if (map.containsKey(curr)) {
        newCurr = map.get(curr);
      } else {
        newCurr = new Node(curr.val);
        map.put(curr, newCurr);
      }
      for (Node neighbor : curr.neighbors) {
        Node newNeighbor; // = (map.containsKey(neighbor)) ? map.get(neighbor) : new Node(neighbor.val);
        if (map.containsKey(neighbor)) {
          newNeighbor = map.get(neighbor);
        } else {
          newNeighbor = new Node(neighbor.val);
          map.put(neighbor, newNeighbor);
        }
        newCurr.neighbors.add(newNeighbor);
        // if ((mask & (1 << neighbor.val)) == 0) {
        //   queue.add(neighbor);
        //   mask |= (1 << neighbor.val);
        // }
        if (!visited.get(neighbor.val)) {
          queue.add(neighbor);
          visited.set(neighbor.val);
        }
      }
    }

    return result;
  }

  public void printGraph(Node node) {
    Queue<Node> queue = new LinkedList<>();
    int mask = 0;
    queue.add(node);
    mask |= (1 << node.val);
    while(!queue.isEmpty()) {
      Node curr = queue.poll();
      System.out.print(curr.val + " -> ");
      for (Node neighbor : curr.neighbors) {
        System.out.print(neighbor.val + " ");
        if ((mask & (1 << neighbor.val)) == 0) {
          queue.add(neighbor);
          mask |= (1 << neighbor.val);
        }
      }
      System.out.println();
    }
  }

  public static void Run() {
    CloneGraph cg = new CloneGraph();
    Node node1 = cg.new Node(1);
    Node node2 = cg.new Node(2);
    Node node3 = cg.new Node(3);
    Node node4 = cg.new Node(4);
    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);
    Node result = cg.cloneGraph(node1);
    cg.printGraph(result);
  }
}
