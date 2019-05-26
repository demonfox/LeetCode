// -----------  Problem Synopsis  ----------- //
// Given a binary tree and a sum, determine if the 
// tree has a root-to-leaf path such that adding up 
// all the values along the path equals the given sum.
// ------------------------------------------ //

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root)
            return false;
        if (null == root.left && null == root.right)
            return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    public static void Run() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right.right = new TreeNode(1);

        PathSum s = new PathSum();

        System.out.println(s.hasPathSum(node, 22));
    }
}