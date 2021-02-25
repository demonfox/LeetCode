// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
// between two nodes p and q as the lowest node in T that has both p and q as descendants 
// (where we allow a node to be a descendant of itself).”

import java.util.Stack;

public class LCAofBT {
    private Stack<TreeNode> pAncestor = new Stack<TreeNode>();
    private Stack<TreeNode> qAncestor = new Stack<TreeNode>();
    private int pDepth = -1;
    private int qDepth = -1;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, 0, 0);
        while (pDepth > qDepth) {
            pAncestor.pop();
            pDepth--;
        }
        while (qDepth > pDepth) {
            qAncestor.pop();
            qDepth--;
        }
        while (pAncestor.peek() != qAncestor.peek()) {
            pAncestor.pop();
            qAncestor.pop();
        }
        return pAncestor.peek();
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q, int pd, int qd) {
        if (root == null)
            return;
        if (pDepth == -1 && root.val == p.val) {
            pDepth = pd;
            pAncestor.push(root);
        }
        if (qDepth == -1 && root.val == q.val) {
            qDepth = qd;
            qAncestor.push(root);
        }
        if (pDepth > -1 && qDepth > -1) {
            return;
        } else {
            if (pDepth == -1) {
                pAncestor.push(root);
            }
            if (qDepth == -1) {
                qAncestor.push(root);
            }
            helper(root.left, p, q, pd+1, qd+1);
            helper(root.right, p, q, pd+1, qd+1);
            if (pDepth == -1) {
                pAncestor.pop();
            }
            if (qDepth == -1) {
                qAncestor.pop();
            }
        }
    }
    
    public void Reset() {
        pAncestor.clear();
        qAncestor.clear();
        pDepth = -1;
        qDepth = -1;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root ==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left == null) ? right : ((right == null) ? left : root);
    }

    public static void Run() {
        LCAofBT l = new LCAofBT();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;
        System.out.println(l.lowestCommonAncestor(n1, n2, n3).val);
        l.Reset();
        System.out.println(l.lowestCommonAncestor(n1, n2, n9).val);
        n1.right = null;
        l.Reset();
        System.out.println(l.lowestCommonAncestor(n1, n1, n2).val);
    }
}
