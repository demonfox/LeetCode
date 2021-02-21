// Given a linked list, return the node where the cycle begins. 
// If there is no cycle, return null.
// There is a cycle in a linked list if there is some node in 
// the list that can be reached again by continuously following 
// the next pointer. Internally, pos is used to denote the index of 
// the node that tail's next pointer is connected to. 
// Note that pos is not passed as a parameter.
// Notice that you should not modify the linked list.

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode i = head;
        ListNode j = head;
        while (i != null && j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
            if (i == j) {
                // cycle found
                i = head;
                while (i != j) {
                    i = i.next;
                    j = j.next;
                }
                return i;
            }
        }
        return null;
    }

    public static void Run() {
        LinkedListCycleII s = new LinkedListCycleII();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        System.out.println(s.detectCycle(n1) == null);
        n4.next = n2;
        System.out.println(s.detectCycle(n1) == n2);
        n2.next = n1;
        System.out.println(s.detectCycle(n1) == n1);
        n1.next = null;
        System.out.println(s.detectCycle(n1) == null);
    }
}
