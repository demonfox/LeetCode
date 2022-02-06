// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
// Return the linked list sorted as well.

import java.util.List;
import java.util.ArrayList;

public class RemoveDuplicatesFromSortedList {
  // You first work out this simple version
  public ListNode deleteDuplicates2(ListNode head) {
    if (head == null) return null;
    ListNode prev, curr;
    prev = head;
    curr = head.next;
    while (curr != null) {
      if (curr.val != prev.val) {
        prev.next = curr;
        prev = curr;
      }
      curr = curr.next;
    }
    prev.next = curr;
    return head;
  }

  // Then optimize it to this slicker version
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    ListNode curr = head;
    while (curr.next != null) {
      if (curr.next.val != curr.val) {
        curr = curr.next;
      } else {
        curr.next = curr.next.next;
      }
    }
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
    RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(2);
    ListNode n4 = new ListNode(3);
    ListNode n5 = new ListNode(3);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    r.deleteDuplicates(n1);
    printList(n1);
  }
}
