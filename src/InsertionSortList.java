// Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

// The steps of the insertion sort algorithm:

// Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
// At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the 
// sorted list and inserts it there.
// It repeats until no input elements remain.

import java.util.ArrayList;
import java.util.List;

public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    if (head.next == null) return head;

    ListNode iter, prev, temp;
    iter = head.next;
    prev = head;
    while (iter != null) {
      if (iter.val >= prev.val) {
        prev = iter;
        iter = iter.next;
      } else if (iter.val <= head.val) {
        prev.next = iter.next;
        iter.next = head;
        head = iter;
        iter = prev.next;
      } else {
        temp = head;
        while (temp.next.val <= iter.val)
          temp = temp.next;
        prev.next = iter.next;
        ListNode t = temp.next;
        temp.next = iter;
        iter.next = t;
        iter = prev.next;
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
    InsertionSortList test = new InsertionSortList();
    ListNode head = new ListNode(4);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(3);
    head = test.insertionSortList(head);
    printList(head);

    head = new ListNode(4);
    head = test.insertionSortList(head);
    printList(head);

    head = new ListNode(1);
    head.next = new ListNode(5);
    head = test.insertionSortList(head);
    printList(head);

    head = new ListNode(5);
    head.next = new ListNode(1);
    head = test.insertionSortList(head);
    printList(head);

    head = new ListNode(-1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(0);
    head = test.insertionSortList(head);
    printList(head);
  }
}
