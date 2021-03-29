// A linked list of length n is given such that each node contains an additional random pointer, which 
// could point to any node in the list, or null.
// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where 
// each new node has its value set to the value of its corresponding original node. Both the next and 
// random pointer of the new nodes should point to new nodes in the copied list such that the pointers 
// in the original list and copied list represent the same list state. None of the pointers in the new 
// list should point to nodes in the original list.
// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the 
// corresponding two nodes x and y in the copied list, x.random --> y.
// Return the head of the copied linked list.
// The linked list is represented in the input/output as a list of n nodes. Each node is represented as 
// a pair of [val, random_index] where:
// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null 
// if it does not point to any node.
// Your code will only be given the head of the original linked list.

import java.util.HashMap;
import java.util.Map;

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
  }
}

public class CopyListWithRandomPointer {
  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<Node, Node>();
    Node newListHead = null;
    Node iterNew = null;
    Node iterOld = head;
    while (iterOld != null) {
      Node newNode = new Node(iterOld.val);
      if (iterNew != null) {
        iterNew.next = newNode;
      } else {
        newListHead = newNode;
      }
      // record the mapping so that we can set the random pointer correctly in the second iteration
      map.put(iterOld, newNode); 
      iterNew = newNode;
      iterOld = iterOld.next;
    }

    iterOld = head;
    iterNew = newListHead;
    while (iterNew != null) {
      if (iterOld.random != null) 
        iterNew.random = map.get(iterOld.random);
      iterOld = iterOld.next;
      iterNew = iterNew.next;
    }
    return newListHead;
  }

  public static void Run() {
    CopyListWithRandomPointer c = new CopyListWithRandomPointer();
    Node n0 = new Node(7);
    Node n1 = new Node(13);
    Node n2 = new Node(11);
    Node n3 = new Node(10);
    Node n4 = new Node(1);
    n0.next = n1;
    n0.random = null;
    n1.next = n2;
    n1.random = n0;
    n2.next = n3;
    n2.random = n4;
    n3.next = n4;
    n3.random = n2;
    n4.next = null;
    n4.random = n0;
    Node newHead = c.copyRandomList(n0);
    int i = 0;
    while (newHead != null) {
      System.out.print("Node " + i++ + ": " + newHead.val + ", random: ");
      if (newHead.random != null)
        System.out.print(newHead.random.val);
      else
        System.out.print("null");
      System.out.println();
      newHead = newHead.next;
    }
  }
}
