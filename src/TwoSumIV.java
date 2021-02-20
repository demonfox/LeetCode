// Given the root of a Binary Search Tree and a target number k, 
// return true if there exist two elements in the BST such that 
// their sum is equal to the given target.
import java.util.HashSet;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        HashSet<Integer> dict = new HashSet<Integer>();
        return helper(root, k, dict);
    }

    private boolean helper(TreeNode root, int k, HashSet<Integer> dict) {
        if (dict.contains(k - root.val)) {
            return true;
        }
        dict.add(root.val);
        boolean result = false;
        if (root.left != null)
            result = helper(root.left, k, dict);
        if (result == true)
            return result;
        if (root.right != null)
            result = helper(root.right, k, dict);
        if (result == true)
            return result;
        return false;
        // you can just write "return helper(root.left, k, dict) || helper(root.right, k, dict)"
        // but it costs a bit more
    }

    public static void Run() {
    	TwoSumIV s = new TwoSumIV();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(s.findTarget(n1, 9));
    }
}
