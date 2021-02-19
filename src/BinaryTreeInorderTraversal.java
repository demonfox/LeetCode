import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// -----------  Problem Synopsis  ----------- //
// Given a binary tree, return the inorder traversal of its nodes' values.
// ------------------------------------------ //

// This class is already defined in TreeNode.java
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class BinaryTreeInorderTraversal {
    // iterative traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curr = root;
        while (null != curr || !stack.isEmpty()) {
            while (null != curr) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(Integer.valueOf(curr.val));
            curr = curr.right;
        }
        return result;
    }
    
    public static void Run() {
        BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        List<Integer> result = s.inorderTraversal(node);
        for (Integer var : result) {
            System.out.println(var.intValue());            
        }

        node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(6);

        result = s.inorderTraversal(node);
        for (Integer var : result) {
            System.out.println(var.intValue());            
        }
    }
}