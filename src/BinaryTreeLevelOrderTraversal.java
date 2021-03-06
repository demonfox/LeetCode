// Given the root of a binary tree, return the level order traversal of its nodes' 
// values. (i.e., from left to right, level by level).
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder2(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();        
        int level = -1;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            int currLevel = Math.abs(curr.val) / 10000;
            curr.val = curr.val % 10000;
            if (currLevel == level) {
                result.getLast().add(curr.val);
            } else {
                LinkedList<Integer> newLevelList = new LinkedList<Integer>();
                newLevelList.add(curr.val);
                result.add(newLevelList);
                level = currLevel;
            }
            if (curr.left != null) {
                curr.left.val = (curr.left.val >= 0) ? curr.left.val + (level+1) * 10000 : curr.left.val - (level+1) * 10000;
                q.add(curr.left);
            }
            if (curr.right != null) {
                curr.right.val = (curr.right.val >= 0) ? curr.right.val + (level+1) * 10000 : curr.right.val - (level+1) * 10000;
                q.add(curr.right);
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>(); 
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> currLevelNodes = new LinkedList<Integer>();
            int nodesOnCurrLevel = q.size();
            while(nodesOnCurrLevel-- != 0) {
                TreeNode node = q.remove();
                currLevelNodes.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            result.add(currLevelNodes);
        }
        return result;
    }

    private ArrayList<List<Integer>> resultUsingDFS;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return resultUsingDFS;
        resultUsingDFS = new ArrayList<List<Integer>>();
        dfsHelper(root, 0);
        return resultUsingDFS;
    }

    private void dfsHelper(TreeNode node, int level) {
        if (node == null)
            return;
        if (resultUsingDFS.size() < level + 1) {
            resultUsingDFS.add(new LinkedList<Integer>());
        }
        resultUsingDFS.get(level).add(node.val);
        dfsHelper(node.left, level+1);
        dfsHelper(node.right, level+1);
    }
    public static void Run() {
        BinaryTreeLevelOrderTraversal t = new BinaryTreeLevelOrderTraversal();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(-20);
        TreeNode n4 = new TreeNode(12);
        TreeNode n5 = new TreeNode(15);
        TreeNode n6 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        List<List<Integer>> result = t.levelOrder(n1);
        for(List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
