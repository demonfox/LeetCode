// Given two integer arrays preorder and inorder where preorder is the 
// preorder traversal of a binary tree and inorder is the inorder traversal 
// of the same tree, construct and return the binary tree.

import java.util.ArrayList;

public class BTfromPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        ArrayList<Integer> leftSubtreePre = new ArrayList<Integer>();
        ArrayList<Integer> leftSubtreeIn = new ArrayList<Integer>();
        ArrayList<Integer> rightSubtreePre = new ArrayList<Integer>();
        ArrayList<Integer> rightSubtreeIn = new ArrayList<Integer>();
        if (preorder.length > 0) {
            root = new TreeNode(preorder[0]);
            ArrayList<Integer> subtreePre = leftSubtreePre;
            ArrayList<Integer> subtreeIn = leftSubtreeIn;
            int preIndex = 1;
            int inIndex = 0;
            for (; inIndex<inorder.length;) {
                if (inorder[inIndex] != root.val) {
                    subtreePre.add(preorder[preIndex++]);
                    subtreeIn.add(inorder[inIndex++]);
                } else {
                    inIndex++;
                    subtreePre = rightSubtreePre;
                    subtreeIn = rightSubtreeIn;
                }
            }
            if (leftSubtreePre.size() > 0) {
                root.left = buildTree(leftSubtreePre.stream().mapToInt(i->i).toArray(), 
                                leftSubtreeIn.stream().mapToInt(i->i).toArray());
            }
            if (rightSubtreePre.size() > 0) {
                root.right = buildTree(rightSubtreePre.stream().mapToInt(i->i).toArray(), 
                                rightSubtreeIn.stream().mapToInt(i->i).toArray());
            }
        }

        return root;
    }

    public static void Run() {
        BTfromPreIn b = new BTfromPreIn();
        TreeNode r = b.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
