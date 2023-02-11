// Given the head of a singly linked list and two integers left and right where left <= right, 
// reverse the nodes of the list from position left to position right, and return the reversed list.

import java.util.*;

public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode tailOfReversedPortion = head;
    ListNode oneNodeBeforeTailOfReversedPortion = null;
    int index = 1;
    while (index <= right) {
      if (index < left) {
        prev = curr;
        curr = curr.next;
      }
      else if (index == left) {
        tailOfReversedPortion = curr;
        oneNodeBeforeTailOfReversedPortion = prev;
        prev = curr;
        curr = curr.next;
      } else if (index > left /* && index <= right */) {
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }
      index++;
    }

    if (oneNodeBeforeTailOfReversedPortion == null) {
      // this means tailOfReversedPortion is head
      head.next = curr;
      return prev;
    } else {
      tailOfReversedPortion.next = curr;
      oneNodeBeforeTailOfReversedPortion.next = prev;
      return head;
    }
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
    ReverseLinkedListII r = new ReverseLinkedListII();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    printList(r.reverseBetween(n1, 2, 4));

    n1.next = null;
    printList(r.reverseBetween(n1, 1, 1));
  }
}
