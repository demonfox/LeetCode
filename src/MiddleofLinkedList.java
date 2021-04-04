// Given a non-empty, singly linked list with head node head, return a middle node of linked list.
// If there are two middle nodes, return the second middle node.

public class MiddleofLinkedList {
  public ListNode middleNode(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast.next != null)
      slow = slow.next;
    return slow;
  }

  public static void Run() {
    MiddleofLinkedList m = new MiddleofLinkedList();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    ListNode mid = m.middleNode(n1);
    System.out.println(mid.val);
    ListNode n6 = new ListNode(6);
    n5.next = n6;
    mid = m.middleNode(n1);
    System.out.println(mid.val);
  }
}
