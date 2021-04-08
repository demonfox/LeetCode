// Write a function to delete a node in a singly-linked list. You will not be given access to the head of 
// the list, instead you will be given access to the node to be deleted directly.
// It is guaranteed that the node to be deleted is not a tail node in the list.

public class DeleteNodeLinkedList {
  public void deleteNode(ListNode node) {
    ListNode prev = null;
    while (node.next != null) {
      node.val = node.next.val;
      prev = node;
      node = node.next;
    }
    prev.next = null;
  }

  public void deleteNode2(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  // This problem is so funny that I cannot even write a test "Run" for it.
}
