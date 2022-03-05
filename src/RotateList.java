// Given the head of a linked list, rotate the list to the right by k places.

import java.util.ArrayList;
import java.util.List;

public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode curr = head;
    int n = 1;
    while (curr.next != null) {
      n++;
      curr = curr.next;
    }

    k = k % n;
    if (k == 0)
      return head;
    ListNode newTail = null;
    curr = head;
    
    while (curr.next != null) {
      if (k == 0)
        newTail = head;
      if(k >= 0)
        k--;
      curr = curr.next;
      if (newTail != null)
        newTail = newTail.next;
    }

    if (k == 0)
      newTail = head;
    
    curr.next = head;
    head = newTail.next;
    newTail.next = null;

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
    RotateList r = new RotateList();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    ListNode head = r.rotateRight(n1, 4);
    printList(head);
  }
}
