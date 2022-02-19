// Given the head of a linked list and an integer val, remove all the nodes of the linked list 
// that has Node.val == val, and return the new head.
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    ListNode prev = null;
    while (head != null && head.val == val) {
      head = head.next;
    }

    ListNode curr = head;
    while (curr != null) {
      if (curr.val == val) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }
    return head;
  }

  public static void Run() {
    RemoveLinkedListElements r = new RemoveLinkedListElements();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(1);
    ListNode n4 = new ListNode(1);
    ListNode n5 = new ListNode(1);
    ListNode n6 = new ListNode(1);
    ListNode n7 = new ListNode(6);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = null;
    ListNode newHead = r.removeElements(n1, 1);
    while (newHead != null) {
      System.out.print(newHead.val + " ");
      newHead = newHead.next;
    }
    System.out.println();
  }
}
