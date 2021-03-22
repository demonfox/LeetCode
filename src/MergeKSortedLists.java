// You are given an array of k linked-lists lists, each linked-list is sorted 
// in ascending order.
//Merge all the linked-lists into one sorted linked-list and return it.

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = null;
    PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(
                                      new Comparator<ListNode>(){
                                        public int compare(ListNode a, ListNode b) {
                                          return (a.val == b.val) ? 0 : ((a.val > b.val) ? 1 : -1);
                                        }
                                      });
    for (ListNode list : lists) {
      if (list != null) {
        ListNode h = list;
        while (h != null) {
          pqueue.add(h);
          h = h.next;
        }
      }
    }

    ListNode prev = null;
    while (!pqueue.isEmpty()) {
      ListNode curr = new ListNode(pqueue.remove().val);
      if (prev == null) {
        head = curr;
        prev = curr;
      } else {
        prev.next = curr;
        prev = curr;
      }

    }
    return head;
  }

  public static void Run() {
    MergeKSortedLists m = new MergeKSortedLists();
    ListNode[] lists = new ListNode[3];
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(4);
    ListNode n3 = new ListNode(5);
    ListNode n4 = new ListNode(1);
    ListNode n5 = new ListNode(3);
    ListNode n6 = new ListNode(4);
    ListNode n7 = new ListNode(2);
    ListNode n8 = new ListNode(6);
    n1.next = n2;
    n2.next = n3;
    n4.next = n5;
    n5.next = n6;
    n7.next = n8;
    lists[0] = n1;
    lists[1] = n4;
    lists[2] = n7;
    ListNode head = m.mergeKLists(lists);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
}
