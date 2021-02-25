// Given a binary search tree (BST), find the lowest common ancestor (LCA) 
// of two given nodes in the BST.
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
// is defined between two nodes p and q as the lowest node in T that has both p 
// and q as descendants (where we allow a node to be a descendant of itself).”

public class LCAofBST {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public static void Run() {
        LCAofBST l = new LCAofBST();
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(9);
        TreeNode n8 = new TreeNode(3);
        TreeNode n9 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;
        System.out.println(l.lowestCommonAncestor(n1, n2, n3).val);
        System.out.println(l.lowestCommonAncestor(n1, n2, n5).val);
        n1.right = null;
        System.out.println(l.lowestCommonAncestor(n1, n1, n2).val);
    }
}
