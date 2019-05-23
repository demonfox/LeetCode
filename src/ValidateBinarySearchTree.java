// -----------  Problem Synopsis  ----------- //
// Given a binary tree, determine if it is a valid binary search tree (BST).
// Assume a BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// ------------------------------------------ //

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
     
public class ValidateBinarySearchTree {
    private boolean isValidBSTHelper(TreeNode root, Integer lower, Integer upper) {
        if (null == root)
            return true;
        if (null != lower) {
            if (root.val <= lower.intValue())
                return false;
        }
        if (null != upper) {
            if (root.val >= upper.intValue())
                    return false;
        }
        return isValidBSTHelper(root.left, lower, root.val) && isValidBSTHelper(root.right, root.val, upper);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public static void Run() {
        ValidateBinarySearchTree s = new ValidateBinarySearchTree();

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        System.out.println(s.isValidBST(node));

        node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(6);

        System.out.println(s.isValidBST(node));
    }
}