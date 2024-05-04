// Given two strings a and b, return the length of the longest uncommon subsequence between a and b. 
// If no such uncommon subsequence exists, return -1.
// An uncommon subsequence between two strings is a string that is a subsequence of exactly one of them.

public class LongestUncommonSubsequenceI {
  public int findLUSlength(String a, String b) {
    if (a.equals(b))
      return -1;
    return Math.max(a.length(), b.length());
  }

  public static void Run() {
    // generate 5 test cases for findLUSlength
    LongestUncommonSubsequenceI lus = new LongestUncommonSubsequenceI();
    String[] a = {"aba", "cdc", "abcde", "ace", "abc", "aaa"};
    String[] b = {"cdc", "dcba", "edcba", "abc", "abcd", "aaa"};
    for (int i=0; i<a.length; i++)
      System.out.println("a = " + a[i] + ", b = " + b[i] + ", LUS = " + lus.findLUSlength(a[i], b[i]));
   
  }
}
