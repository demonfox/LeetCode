// Given the root of a binary tree, check whether it is a mirror of 
// itself (i.e., symmetric around its center).

import java.util.Queue;
import java.util.LinkedList;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return isTheSameTree(root.left, root.right);
    }

    private boolean isTheSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left != null && right != null) {
            if (left.val != right.val)
                return false;
            return isTheSameTree(left.left, right.right) && isTheSameTree(left.right, right.left);
        }
        return false;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left  = q.remove();
            TreeNode right = q.remove();
            if (left == null && right == null)
                continue;
            if (left != null && right != null) {
                if (left.val != right.val)
                    return false;
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void Run() {
        SymmetricTree s = new SymmetricTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(s.isSymmetric(n1));
        System.out.println(s.isSymmetric2(n1));
        n2.left = null;
        n2.right = n4;
        n3.left = null;
        System.out.println(s.isSymmetric(n1));
        System.out.println(s.isSymmetric2(n1));
    }
}
