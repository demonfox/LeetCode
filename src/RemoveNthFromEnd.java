// -----------  Problem Synopsis  ----------- //
// Given a linked list, remove the nth node from the end of list and return its head.
// For example,
//   Given linked list: 1->2->3->4->5, and n = 2.
// After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
//   Given n will always be valid.
//   Try to do this in one pass.
// ------------------------------------------ //

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head;
        ListNode ptr2 = null; // ptr2 is the node to be removed
        ListNode ptr3 = null;
        while (ptr1 != null) {
            ptr1 = ptr1.next;
            if (ptr2 != null ) {
                // wait until ptr1 is n-step ahead before starting to move ptr2
                ptr3 = ptr2;
                ptr2 = ptr2.next;
            }
            n--;
            // now that ptr1 is n-step ahead, let ptr2 start to move
            if (n == 0) {
                ptr2 = head;
            }
        }
        if (ptr2 == head)
            head = ptr2.next;
        else
            ptr3.next = ptr2.next;
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
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;
        printList(n1);
        ListNode result = r.removeNthFromEnd(n1, 5);
        printList(result);
    }
}
