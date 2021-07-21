// Given the head of a singly linked list, group all the nodes with odd indices together 
// followed by the nodes with even indices, and return the reordered list.
// The first node is considered odd, and the second node is even, and so on.
// Note that the relative order inside both the even and odd groups should remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null)
      return head;
    ListNode p1 = head;
    ListNode p2 = head.next;
    ListNode startOfEvenNode = head.next;
    ListNode p3 = head.next.next;
    while (p3 != null && p2 != null) {
      p1.next = p3;
      p2.next = p3.next;
      p1 = p1.next;
      p2 = p2.next;
      // we don't need to check for p1 because in this loop, p1 = p1.next = p3, which is
      // guaranteed to not be null by the while condition
      if (p2 != null)
        p3 = p2.next;
      // else if p2 == null, then we will break in the next while iteration
    }
    p1.next = startOfEvenNode;
    return head;
  }

  public static void printList(ListNode node) {
    List<String> s = new ArrayList<String>();
    while(node != null) {
        s.add(Integer.toString(node.val));
        node = node.next;
    }
    System.out.println(String.join("->", s));
  }

  public static void Run() {
    OddEvenLinkedList o = new OddEvenLinkedList();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = null;
    ListNode head = o.oddEvenList(n1);
    printList(head);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = null;
    head = o.oddEvenList(n1);
    printList(head);
  }
}
