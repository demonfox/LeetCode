// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving 
// only distinct numbers from the original list. Return the linked list sorted as well.

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    int dupCount = 1;
    
    // first we need to find the first unique/non-dup node in the list
    while (true) {
      dupCount = 1;
      while(head.next != null && head.val == head.next.val) {
        dupCount++;
        head = head.next;
      }
      if (dupCount > 1) {
        if (head.next == null) 
          return null; // the string only has one duplicated node, so return null
        
        // the starting portion is a bunch of duplicate nodes, so skip them
        head = head.next;
      } else {
        break;
      }    
    }
    
    ListNode result = head;
    ListNode start = head.next;
    if (start == null) return head;
    while (start != null && start.next != null) {
      dupCount = 1;
      while (start.next != null && start.val == start.next.val) {
        dupCount++;
        start = start.next;
      }
      if (dupCount > 1) {
        // this is a duplicate node, so skip it
        head.next = start.next;
        start = start.next;
      } else {
        // this is not a duplicate node, so keep it
        head = start;
        start = start.next;
      }
    }
    return result;
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
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
    ListNode result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
    printList(result);

    head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
    result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
    printList(result);

    head = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
    result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
    printList(result);

    head = new ListNode(1);
    result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
    printList(result);

    head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));
    result = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
    printList(result);
  }
}
