// Print a binary tree in an m*n 2D string array following these rules:
// 1. The row number m should be equal to the height of the given binary tree.
// 2. The column number n should always be an odd number.
// 3. The root node's value (in string format) should be put in the exactly middle of the first row 
// it can be put. The column and the row where the root node belongs will separate the rest space 
// into two parts (left-bottom part and right-bottom part). You should print the left subtree in the 
// left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and 
// the right-bottom part should have the same size. Even if one subtree is none while the other is 
// not, you don't need to print anything for the none subtree but still need to leave the space as 
// large as that for the other subtree. However, if two subtrees are none, then you don't need to 
// leave space for both of them.
// 4. Each unused space should contain an empty string "".
// 5. Print the subtrees following the same rules.

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {
  public List<List<String>> printTree(TreeNode root) {
    // 1) Do a level order traversal of to find out
    // totalDepth = keep a counter
    // totalWidth = 2^totalDepth - 1
    // 2) Do a second level order traversal and add the necessary space:
    // For every level:
    // numOfNodes = 2^(currLevel-1)
    // numOfLeadingSpaces = 2^(totalDepth-currLevel)-1
    // numOfSpacesBetweenNodes = (totalWidth - 2*numOfLeadingSpaces - numOfNodes) / (numOfNodes-1)
    List<List<String>> result = new LinkedList<List<String>>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int currLevel = 0;
    int totalDepth = 0;
    int totalWidth;
    while (!q.isEmpty()) {
      currLevel++;
      int numOfNodesOnCurrLevel = q.size();
      while (numOfNodesOnCurrLevel-- > 0) {
        TreeNode node = q.remove();
        if (node.left != null)
          q.add(node.left);
        if (node.right != null)
          q.add(node.right);
      }
    }
    totalDepth = currLevel;
    totalWidth = (int) Math.pow(2.0, (double) totalDepth) - 1;

    q.add(root);
    currLevel = 0;

    while (!q.isEmpty()) {
      currLevel++;
      List<String> currLevelPrint = new LinkedList<>();
      // numOfFullNodes = 2^(currLevel-1)
      // numOfLeadingSpaces = 2^(totalDepth-currLevel)-1
      // numOfSpacesBetweenNodes = (totalWidth - 2*numOfLeadingSpaces - numOfFullNodes) / (numOfFullNodes-1)
      int numOfFullNodes = (int)Math.pow(2.0, (double)(currLevel-1));
      int numOfLeadingSpaces = (int) Math.pow(2.0, (double) (totalDepth - currLevel)) - 1;
      int numOfSpacesBetweenNodes = (numOfFullNodes == 1) ? 0 : (int)((totalWidth - 2*numOfLeadingSpaces - numOfFullNodes) / (numOfFullNodes-1));
      
      int numOfNodesOnCurrLevel = q.size();
      boolean hasNextLevel = false;
      while (numOfNodesOnCurrLevel-- > 0) {
        TreeNode node = q.remove();
        if (numOfNodesOnCurrLevel == numOfFullNodes-1) { // first iteration on this level
          for (int i = 0; i < numOfLeadingSpaces; i++)
            currLevelPrint.add("");
        } else {
          for (int i = 0; i < numOfSpacesBetweenNodes; i++)
            currLevelPrint.add("");
        }
        if (node != null)
          currLevelPrint.add(String.valueOf(node.val));
        else
          currLevelPrint.add("");
        q.add((node == null) ? null : node.left);
        q.add((node == null) ? null : node.right);
        hasNextLevel = hasNextLevel || (node != null && node.left != null) || (node != null && node.right != null);
      }
      for (int i = 0; i < numOfLeadingSpaces; i++)
        currLevelPrint.add("");
      result.add(currLevelPrint);
      if (!hasNextLevel)
        q.clear();
    }

    return result;
  }

  public static void Run() {
    PrintBinaryTree p = new PrintBinaryTree();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    n1.left = n2;
    List<List<String>> printout = p.printTree(n1);
    printTree(printout);
    
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    n1.right = n3;
    n2.right = n4;
    printout = p.printTree(n1);
    printTree(printout);

    TreeNode n5 = new TreeNode(5);
    n1.right = n5;
    n2.left = n3;
    n3.left = n4;
    n2.right = null;
    printout = p.printTree(n1);
    printTree(printout);
  }

  public static void printTree(List<List<String>> printout) {
    for (List<String> l : printout) {
      for (String s: l) {
        System.out.print("\"" + s + "\", ");
      }
      System.out.println();
    }
  }
}
