// -----------  Problem Synopsis  ----------- //
// Given two binary trees, write a function to 
// check if they are the same or not.
// Two binary trees are considered the same if
// they are structurally identical and the nodes 
// have the same value.
// ------------------------------------------ //

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q)
            return true;
        if ((null != p && null == q) || (null == p && null != q))
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static void Run() {
        SameTree s = new SameTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        n4.left = n5;
        n4.right = n6;
        
        System.out.println(s.isSameTree(n1, n4));

        n1.right = null;
        n4.left = null;
        n6.val = 2;

        System.out.println(s.isSameTree(n1, n4));

        n1.right = n3;
        n3.val = 1;
        n4.left = n5;
        n5.val = 1;

        System.out.println(s.isSameTree(n1, n4));
    }
}