// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReorderList {
  public void reorderList(ListNode head) {
    if (head.next == null) return;
    if (head.next.next == null) return;
    ListNode iter = head.next;
    Stack<ListNode> right = new Stack<ListNode>();
    while (iter != null) {
      right.add(iter);
      iter = iter.next;
    }
    ListNode left = head;
    while(true) {
      ListNode r = right.pop();
      if (r == left) {
        left.next = null;
        return;
      }
      if (r == left.next) {
        r.next = null;
        return;
      }
      ListNode l = left.next;
      left.next = r;
      r.next = l;
      
      left = l;
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
    ReorderList rl = new ReorderList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    rl.reorderList(head);
    printList(head);

    head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    rl.reorderList(head);
    printList(head);
  }
}
