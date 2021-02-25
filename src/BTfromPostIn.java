// Given two integer arrays inorder and postorder where inorder is the 
// inorder traversal of a binary tree and postorder is the postorder 
// traversal of the same tree, construct and return the binary tree.

public class BTfromPostIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, inorder.length);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int len) {
        TreeNode root = null;
        if (len > 0) {
            root = new TreeNode(postorder[len-1]);
            int[] leftSubtreeIn = new int[len];
            int[] leftSubtreePost = new int[len];
            int[] rightSubtreeIn = new int[len];
            int[] rightSubtreePost = new int[len];
            int inIndex = 0;
            int postIndex = 0;
            int leftSubtreeLen = 0;
            int rightSubtreeLen = -1;
            for (; inIndex < len;) {
                if (inorder[inIndex] != root.val && rightSubtreeLen == -1) {
                    leftSubtreeIn[inIndex] = inorder[inIndex];
                    leftSubtreePost[postIndex] = postorder[postIndex];
                    inIndex++;
                    postIndex++;
                    leftSubtreeLen++;
                } else {
                    if (rightSubtreeLen == -1) {
                        // here I am just skipping the root node and getting ready to build the
                        // traversal array of the right subtree
                        inIndex++;
                        rightSubtreeLen = 0;
                    } else {
                        rightSubtreeIn[postIndex - leftSubtreeLen] = inorder[inIndex];
                        rightSubtreePost[postIndex - leftSubtreeLen] = postorder[postIndex];
                        inIndex++;
                        postIndex++;
                        rightSubtreeLen++;
                    }
                }
            }
            if (leftSubtreeLen > 0) {
                root.left = helper(leftSubtreeIn, leftSubtreePost, leftSubtreeLen);
            }
            if (rightSubtreeLen > 0) {
                root.right = helper(rightSubtreeIn, rightSubtreePost, rightSubtreeLen);
            }            
        }
        return root;
    }

    public static void Run() {
        BTfromPostIn b = new BTfromPostIn();
        TreeNode r = b.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}