// Given a linked list, reverse the nodes of a linked list k at a time 
// and return its modified list.
// k is a positive integer and is less than or equal to the length of 
// the linked list. If the number of nodes is not a multiple of k then 
// left-out nodes, in the end, should remain as it is.

import java.util.*;

public class ReverseNodesInK {
    private boolean checkKNodesNotNull(ListNode node, int k) {
        while (node != null && k > 0) {
            k--;
            node = node.next;
        }
        return k == 0;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode prev = null;
        ListNode i = head;
        while (checkKNodesNotNull(i, k)) {
            ListNode first = i;
            ListNode second = first.next;
            ListNode third = second.next;
            for (int j=2; j<=k; j++) {
                second.next = first;
                first = second;
                second = third;
                third = (second != null) ? second.next : null;
            }

            // ListNode temp = i.next;
            // i.next = temp.next;
            // temp.next = i;

            if (prev == null)
                head = first;
            else
                prev.next = first;

            prev = i;
            i.next = second;
            i = second;
            //prev = i;
            //i = prev.next;
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
        ReverseNodesInK s = new ReverseNodesInK();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        //n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        printList(s.reverseKGroup(n1, 1));
    }
}
