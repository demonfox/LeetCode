// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
// height-balanced binary search tree.

import java.util.LinkedList;

public class SortedListToBST {
  public TreeNode sortedListToBST1(ListNode head) {
    if (head == null) return null;

    LinkedList<Integer> list = new LinkedList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }

    SortedArrayToBST s = new SortedArrayToBST();
    int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();
    return s.sortedArrayToBST(intArray);
  }

  public TreeNode sortedListToBST(ListNode head) {
    return helper(head, null);
  }

  private TreeNode helper(ListNode head, ListNode tail) {
    TreeNode currRoot;
    if (head == tail) {
      currRoot = (head != null) ? new TreeNode(head.val) : null;
    } else {
      ListNode curr, curr2;
      curr = curr2 = head;
      while (curr2 != tail) {
        curr2 = curr2.next;
        if (curr2 != tail) {
          curr2 = curr2.next;
          curr = curr.next;
        } else {
          break;
        }
      }
      currRoot = new TreeNode(curr.val);
      // if head == curr, that means curr does not move even once, so there is no more left child for currRoot
      currRoot.left = (head == curr) ? null : helper(head, curr); 
      currRoot.right = (curr.next == tail) ? null : helper(curr.next, tail);
    }
    return currRoot;
  }

  public static void printTree(TreeNode root) {
    PrintBinaryTree p = new PrintBinaryTree();
    PrintBinaryTree.printTree(p.printTree(root));
  }

  public static void Run() {
    SortedListToBST s = new SortedListToBST();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    TreeNode root = s.sortedListToBST(head);
    printTree(root);
  }
}
