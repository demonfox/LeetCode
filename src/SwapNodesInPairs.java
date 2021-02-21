// Given a linked list, swap every two adjacent nodes and return its head.

import java.util.*;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode i = head;
        while (i != null && i.next != null) {
            // This is based on swapping values
            // int temp = i.val;
            // i.val = i.next.val;
            // i.next.val = temp;
            // i = i.next.next;

            // This is based on swapping pointers
            if (prev == null)
                head = i.next;
            else
                prev.next = i.next;
            ListNode temp = i.next;
            i.next = temp.next;
            temp.next = i;

            prev = i;
            i = prev.next;
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
        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        printList(s.swapPairs(n1));
    }
}
