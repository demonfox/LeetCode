import java.util.ArrayList;
import java.util.List;

// -----------  Problem Synopsis  ----------- //
// Given a binary tree and a sum, find all root-to-leaf 
// paths where each path's sum equals the given sum.
// ------------------------------------------ //

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();

        if (null != root) {
            List<Integer> pathNodes = new ArrayList<Integer>();
            helper(root, sum, pathNodes, solutions);
        }
    
        return solutions;
    }

    private void helper(TreeNode node, int sum, List<Integer> pathNodes, List<List<Integer>> solutions) {
        if (null == node)
            return;

        pathNodes.add(node.val);

        if (null == node.left && null == node.right) {
            if (sum == node.val) {
                List<Integer> solution = new ArrayList<Integer>();
                solution.addAll(pathNodes);
                solutions.add(solution);
            }
        }

        helper(node.left, sum - node.val, pathNodes, solutions);
        helper(node.right, sum - node.val, pathNodes, solutions);
        pathNodes.remove(pathNodes.size()-1);
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
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

        PathSumII s = new PathSumII();
        List<List<Integer>> result = s.pathSum(node, 22);

        for (List<Integer> var : result) {
            System.out.println(var);
        }   
    }
}