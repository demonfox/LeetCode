// Given a string s, partition s such that every substring of the partition is a palindrome. 
// Return all possible palindrome partitioning of s.
// A palindrome string is a string that reads the same backward as forward.

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
  private List<List<String>> result;
  public List<List<String>> partition(String s) {
    result = new LinkedList<List<String>>();
    boolean[][] dp = new boolean[s.length()][s.length()];
    // Initialization not really needed
    // for (int i=0; i<s.length(); i++)
    //   dp[i][i] = true;
    helper(s, 0, new LinkedList<String>(), dp);
    return result;
  }

  private void helper(String s, int start, List<String> currPartition, boolean[][] dp) {
    if (start == s.length()) {
      List<String> partition = new LinkedList<>();
      partition.addAll(currPartition);
      result.add(partition);
    }
    for (int i=start; i<s.length(); i++) {
      //if (isPalindrome(s, start, i)) {
      if ((s.charAt(start) == s.charAt(i)) && ((i - start) <= 2 || dp[start+1][i-1] == true)) {
        dp[start][i] = true;
        currPartition.add(s.substring(start, i+1));
        helper(s, i+1, currPartition, dp);
        currPartition.remove(currPartition.size()-1);
      }
    }
  }

  // private boolean isPalindrome(String s, int left, int right) {
  //   while (left < right) {
  //     if (s.charAt(left) != s.charAt(right)) 
  //       return false;
  //     left++;
  //     right--;
  //   }
  //   return true;
  // }

  public static void Run() {
    PalindromePartitioning p = new PalindromePartitioning();
    List<List<String>> r = p.partition("aabaa");
    for (List<String> partition : r) {
      partition.forEach(s -> System.out.print(s + " "));
      System.out.println();
    }
  }
}
