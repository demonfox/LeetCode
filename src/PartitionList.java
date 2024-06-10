// Given the head of a linked list and a value x, partition it such that all nodes less than x come 
// before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    if (head.next == null) return head;

    ListNode prev, curr, sentinel;
    prev = head;
    curr = head.next;
    sentinel = null;

    if (head.val < x) {
      sentinel = head;
    }

    while (curr != null) {
      if (curr.val < x) {
        ListNode temp = curr.next; 

        if (sentinel == null) {
          sentinel = curr;
          sentinel.next = head;
          head = sentinel;
          prev.next = temp; // if temp == null, then this terminate the portion of the chain where it's >= x
                            // if temp != null, then this links prev to the rest of the chain
        } else if (sentinel == prev) {
          sentinel = prev = curr;
        } else {
          prev.next = curr.next; // remove curr from the chain
          // insert curr into the front portion of the chain
          curr.next = sentinel.next;
          sentinel.next = curr;
          sentinel = curr;
        }
        
        curr = temp; // advance curr
      } else {
        prev = curr;
        curr = curr.next;
      }
    }

    return head;    
  }

  public static void Run() {
    // generate a test case for partition
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);

    ListNode result = new PartitionList().partition(head, 3);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }

    System.out.println();

    // generate a test case with [2, 1]
    head = new ListNode(2);
    head.next = new ListNode(1);
    result = new PartitionList().partition(head, 2);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }

    System.out.println();

    // generate a test case with [1,1]
    head = new ListNode(1);
    head.next = new ListNode(1);
    result = new PartitionList().partition(head, 2);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }

    System.out.println();

    // generate a test case with [1,2,3]
    head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    result = new PartitionList().partition(head, 4);
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }
}
