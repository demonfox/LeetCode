// -----------  Problem Synopsis  ----------- //
// Two elements of a binary search tree (BST) are swapped by mistake.
// Recover the tree without changing its structure.
// ------------------------------------------ //

import java.util.List;

public class RecoverBinarySearchTree {
    private TreeNode wrongNode1 = null;
    private TreeNode wrongNode2 = null;
    private TreeNode min = null;

    public void recoverTree (TreeNode root) {
        locateWrongNode(root);
        int tmp = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = tmp;
    }

    // 1. An in-order traversal will first walk the left subtree of a node - the item that
    // traversal touches the last the right-most node of the left subtree of that node, and
    // that right-most node should have the largest value among the nodes in the left subtree.
    // 2. So the recursive algorithm here is supposed to find the largest value in its left
    // subtree (becuase we are always assigning min = curr) and then the algorithm visits this
    // curr node.  Then we can if the curr node's val is smaller than min - if it is, then that
    // is a wrong node.
    // 3. Then we traverse the right node (locateWrongNode(curr.right)).  Before we do that, we
    // assign min = curr because the curr node, which the root of the right sub-tree should be
    // the lowest floor vale for its right sub-tree.
    private void locateWrongNode(TreeNode curr) {
        if (curr == null)
            return;
        locateWrongNode(curr.left);
        if (min != null && curr.val < min.val) {
            // the if part here means we just find the first node whose val < min
            // the else part means, we have already found some node *to the left* 
            // the curr node (because we did "locateWrongNode" first), but now we
            // just find another node (the curr one) that is also < min. However,
            // the curr node is *to the right* of the previous found wrongNode2. 
            // If we only swap, min (wrongNode1) and wrongNode2, we increase the val
            // of wrongNode2 (because curr.val < min.val), but for one, this may break
            // the relationship between wrongNode2 and curr since curr is supposed to
            // be > wrongNode2 but we just increased wrongNode2; for two, even if we 
            // swap min (wrongNode1) and wrongNode2, we still have not fixed the issue 
            // of curr < min, because not matter where min is at (wrongNode1 or wrongNode2),
            // it is always to the left of curr, which is supposed to be < curr.
            if (wrongNode1 == null) {
                wrongNode1 = min;
                wrongNode2 = curr;
            } else {
                wrongNode2 = curr;
            }
        }
        min = curr;
        locateWrongNode(curr.right);
    }

    public static void Run() {
        RecoverBinarySearchTree s = new RecoverBinarySearchTree();
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        
        BinaryTreeInorderTraversal r = new BinaryTreeInorderTraversal();
        
        List<Integer> result = r.inorderTraversal(n1);
        for (Integer var : result) {
            System.out.println(var.intValue());            
        }

        System.out.println("Start recovering");
        s.recoverTree(n1);
        System.out.println("Done recovering");

        result = r.inorderTraversal(n1);
        for (Integer var : result) {
            System.out.println(var.intValue());            
        }
    }
}