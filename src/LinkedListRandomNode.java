// Given a singly linked list, return a random node's value from the linked list. Each node must have the same 
// probability of being chosen.
// Implement the Solution class:
// Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
// int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be 
// equally likely to be chosen.

import java.util.HashMap;
import java.util.Random;

public class LinkedListRandomNode {
  HashMap<Integer, ListNode> sentinels;
  int totalNodes = 0;
  Random random = new Random();

  public LinkedListRandomNode(ListNode head) {
    sentinels = new HashMap<>();
    ListNode iter = head;
    sentinels.put(0, head);
    while (iter != null) {
      totalNodes++;
      if (totalNodes % 100 == 0) {
        sentinels.put(totalNodes, iter);
      }
      iter = iter.next;
    }
  }

  public int getRandom() {
    int r = random.nextInt(totalNodes);
    int index = (r / 100) * 100;
    int remainder = r - index;
    ListNode start = sentinels.get(index);
    while (remainder > 0) {
      start = start.next;
      remainder--;
    }
    return start.val;
  }

  public static void Run() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    // head.next.next.next = new ListNode(4);
    // head.next.next.next.next = new ListNode(5);
    // head.next.next.next.next.next = new ListNode(6);
    // head.next.next.next.next.next.next = new ListNode(7);
    // head.next.next.next.next.next.next.next = new ListNode(8);
    // head.next.next.next.next.next.next.next.next = new ListNode(9);
    // head.next.next.next.next.next.next.next.next.next = new ListNode(10);
    // head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
    // head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);

    LinkedListRandomNode solution = new LinkedListRandomNode(head);
    System.out.println(solution.getRandom());
    System.out.println(solution.getRandom());
    System.out.println(solution.getRandom());
    System.out.println(solution.getRandom());
    System.out.println(solution.getRandom());
    System.out.println(solution.getRandom());
    System.out.println(solution.getRandom());
  }
}
