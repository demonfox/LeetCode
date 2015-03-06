// -----------  Problem Synopsis  ----------- //
// You are given two linked lists representing two non-negative numbers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// ------------------------------------------ //

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode root = null;
        ListNode curr = null;
        ListNode prev = null;
        ListNode iter1 = l1;
        ListNode iter2 = l2;
        int val = 0;
        int carry = 0;
        
        while (iter1 != null || iter2 != null) {
            curr = new ListNode(0);
            if (root == null) 
                root = curr;
            
            val = carry;
            if (iter1 != null) {
                val += iter1.val;
                iter1 = iter1.next;
            }
            if (iter2 != null) {
                val += iter2.val;
                iter2 = iter2.next;
            }
            
            if (val >= 10) {
                val %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            curr.val = val;
            if (prev != null)
                prev.next = curr;
            prev = curr;
        }
        
        if (carry == 1) {
            curr = new ListNode(1);
            prev.next = curr;
        }
        
        return root;
    }
    
    public static void Run() {
        AddTwoNumbers s = new AddTwoNumbers();
        
        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(4);
        ListNode m3 = new ListNode(3);
        
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);

        m1.next = m2; 
        m2.next = m3;
        n1.next = n2; 
        n2.next = n3;
        n3.next = n4;     
        n4.next = n5;
        
        ListNode root = s.addTwoNumbers(m1, n1);
        
        for (ListNode iter = root; iter != null; iter = iter.next) {
            System.out.print(iter.val);
        }
    }
}
