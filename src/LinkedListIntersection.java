// Write a program to find the node at which the intersection of two singly linked lists begins.

public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int aLen = 1;
        int bLen = 1;
        ListNode aIter = headA;
        ListNode bIter = headB;
        while (aIter.next != null) {
            aIter = aIter.next;
            aLen++;
        }
        while (bIter.next != null) {
            bIter = bIter.next;
            bLen++;
        }

        // this means these two lists have intersection;
        if (aIter != null && bIter != null && aIter == bIter) {
            aIter = headA;
            bIter = headB;
            if (aLen >= bLen) {
                for (int k=aLen-bLen; k>0; k--) {
                    aIter = aIter.next;
                }
            } else {
                for (int k=bLen-aLen; k>0; k--) {
                    bIter = bIter.next;
                }
            }
            while (aIter != bIter) {
                aIter = aIter.next;
                bIter = bIter.next;
            }
            return aIter;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode aIter = headA;
        ListNode bIter = headB;
        while (aIter != bIter) {
            aIter = (aIter != null) ? aIter.next : headB;
            bIter = (bIter != null) ? bIter.next : headA;
        }
        return aIter;
    }

    public static void Run() {
        LinkedListIntersection l = new LinkedListIntersection();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        ListNode n8 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        n6.next = n7;
        n7.next = n8;
        n8.next = n3;
        System.out.println(l.getIntersectionNode(n1, n6).val);
        System.out.println(l.getIntersectionNode2(n1, n6).val);
    }
}
