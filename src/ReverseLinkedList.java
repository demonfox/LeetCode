// Given the head of a singly linked list, reverse the list, and return the reversed list.

import java.util.*;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printList(r.reverseList(n1));
    }
}
