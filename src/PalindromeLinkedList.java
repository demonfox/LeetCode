// Given the head of a singly linked list, return true if it is a palindrome.
public class PalindromeLinkedList {
  private ListNode currLeft;

  public boolean isPalindrome(ListNode head) {
    currLeft = head;
    return helper(head);
  }

  // we are using the calling stack to remember & rewind the linked list
  // in reverse order
  private boolean helper(ListNode currRight) {
    if (currRight.next == null) {
      // we are at the end of the list
      boolean result = currRight.val == currLeft.val;
      return result;
    }
    if (helper(currRight.next)) {
      currLeft = currLeft.next;
      return currRight.val == currLeft.val;
    }
    return false;
  }

  public static void Run() {
    PalindromeLinkedList p = new PalindromeLinkedList();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(2);
    ListNode n4 = new ListNode(1);
    n1.next = n2;
    System.out.println(p.isPalindrome(n1));
    n2.next = n3;
    n3.next = n4;
    System.out.println(p.isPalindrome(n1));
  }
}
