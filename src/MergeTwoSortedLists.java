// -----------  Problem Synopsis  ----------- //
// Merge two sorted linked lists and return it as a sorted list. 
// The list should be made by splicing together the nodes of the first two lists.
// ------------------------------------------ //

// This class is already defined in ListNode.java
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode s1 = l1;
        ListNode s2 = l2;
        ListNode result = null;
        ListNode curr = null;
        while (s1 != null || s2 != null) {
            if (result == null) {
                curr = new ListNode(0);
                result = curr;
            } else {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
            if (s1 == null) {
                curr.val = s2.val;
                s2 = s2.next;
            } else if (s2 == null) {
                curr.val = s1.val;
                s1 = s1.next;
            } else if (s1.val > s2.val) {
                curr.val = s2.val;
                s2 = s2.next;
            } else {
                curr.val = s1.val;
                s1 = s1.next;
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
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(15);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        printList(m.mergeTwoLists(n1, n5));
    }
}
