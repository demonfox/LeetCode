// Given the head of a linked list, return the list after sorting it in ascending order.
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

public class SortList {
  public ListNode sortList(ListNode head) {
    // we can leverage the idea of mergesort and adapt it to fit a linkedlist:
    // Array A[] has the items to sort; array B[] is a work array.
    // void TopDownMergeSort(A[], B[], n) {
    // CopyArray(A, 0, n, B); // one time copy of A[] to B[]
    // TopDownSplitMerge(B, 0, n, A); // sort data from B[] into A[]
    // }
    // Split A[] into 2 runs, sort both runs into B[], merge both runs from B[] to
    // A[]
    // iBegin is inclusive; iEnd is exclusive (A[iEnd] is not in the set).
    // void TopDownSplitMerge(B[], iBegin, iEnd, A[]) {
    // if(iEnd - iBegin <= 1) // if run size == 1
    // return; // consider it sorted
    // split the run longer than 1 item into halves
    // iMiddle = (iEnd + iBegin) / 2; // iMiddle = mid point
    // recursively sort both runs from array A[] into B[]
    // TopDownSplitMerge(A, iBegin, iMiddle, B); // sort the left run
    // TopDownSplitMerge(A, iMiddle, iEnd, B); // sort the right run
    // merge the resulting runs from array B[] into A[]
    // TopDownMerge(B, iBegin, iMiddle, iEnd, A);
    // }
    // Left source half is A[iBegin : iMiddle-1].
    // Right source half is A[iMiddle : iEnd-1].
    // Result is B[iBegin : iEnd-1].
    // void TopDownMerge(A[], iBegin, iMiddle, iEnd, B[]) {
    // i = iBegin, j = iMiddle;
    // While there are elements in the left or right runs...
    // for (k = iBegin; k < iEnd; k++) {
    // If left run head exists and is <= existing right run head.
    // if (i < iMiddle && (j >= iEnd || A[i] <= A[j])) {
    // B[k] = A[i];
    // i = i + 1;
    // } else {
    // B[k] = A[j];
    // j = j + 1;
    // }
    // }
    // }
    // void CopyArray(A[], iBegin, iEnd, B[]) {
    // for(k = iBegin; k < iEnd; k++)
    // B[k] = A[k];
    // }
    if (head == null || head.next == null)
      return head;
    ListNode mid = findMiddle(head);
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(mid);
    return TopDownMerge(l1, l2);
  }

  private ListNode findMiddle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    ListNode slowPrev = null;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slowPrev = slow;
      slow = slow.next;
    }
    if (fast.next != null) {
      slowPrev = slow;
      slow = slow.next;
    }
    slowPrev.next = null;

    return slow;
  }

  private ListNode TopDownMerge(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode ptr = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        ptr.next = l1;
        l1 = l1.next;
        ptr = ptr.next;
      } else {
        ptr.next = l2;
        l2 = l2.next;
        ptr = ptr.next;
      }
    }
    ptr.next = (l1 != null) ? l1 : l2;
    return dummyHead.next;
  }

  public static void Run() {
    SortList s = new SortList();
    ListNode n1 = new ListNode(-1);
    ListNode n2 = new ListNode(5);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(0);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    ListNode h = s.sortList(n1);
    while (h != null) {
      System.out.print(h.val + " ");
      h = h.next;
    }
    System.out.println();
  }
}
