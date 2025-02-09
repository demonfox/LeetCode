// Given two strings s and t, return the number of distinct subsequences of s which equals t.
// The test cases are generated so that the answer fits on a 32-bit signed integer.

public class DistinctSubsequences {
  private int result;

  // dynamic programming
  public int numDistinct(String s, String t){
    // Define a state transition function DP[i][j] as the number of distinct subsequences of s[0...i] which equals t[0...j]
    // Observe:
    // if s[i] != t[j], then DP[i][j] = DP[i-1][j] since s[i] cannot contribute, we can only use s[0...i-1] to get t[0...j]
    // if s[i] == t[j], then DP[i][j] = DP[i-1][j]  # leaving out s[i]
    //                                + DP[i-1][j-1] # let s[i] contribute to t[j]
    int[][] DP = new int[s.length()+1][t.length()+1];
    for (int i=0; i<s.length()+1; i++)
      DP[i][0] = 1; // if t is empty, then there is only 1 subsequence of s which equals to t, which is the empty string
    for (int j=1; j<t.length()+1; j++)
      DP[0][j] = 0;
    for (int i=1; i<s.length()+1; i++) {
      for (int j=1; j<t.length()+1; j++) {
        if (s.charAt(i-1) != t.charAt(j-1)) {
          DP[i][j] = DP[i-1][j];
        } else {
          DP[i][j] = DP[i-1][j] + DP[i-1][j-1];
        }
      }
    }
    return DP[s.length()][t.length()];
  }

  // backtracking
  public int numDistinct2(String s, String t) {
    result = 0;
    backtrack(s, 0, t, 0);
    return result;
  }
  
  private void backtrack(String s, int sIndex, String t, int tIndex) {
    if (tIndex == t.length()) {
      result++;
      return;
    }
    
    for (int i=sIndex; i<s.length(); i++) {
      if (s.charAt(i) != t.charAt(tIndex))
        continue;
      
      backtrack(s, i+1, t, tIndex+1);
    }
  }

  public static void Run() {
    DistinctSubsequences d = new DistinctSubsequences();
    System.out.println(d.numDistinct("babgbag", "bag"));
    System.out.println(d.numDistinct("rabbbit", "rabbit"));
    System.out.println(d.numDistinct("aaa", "a"));
    System.out.println(d.numDistinct("aaa", "aa"));
    System.out.println(d.numDistinct("aaa", "aaa"));
    System.out.println(d.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));

    System.out.println(d.numDistinct2("babgbag", "bag"));
    System.out.println(d.numDistinct2("rabbbit", "rabbit"));
    System.out.println(d.numDistinct2("aaa", "a"));
    System.out.println(d.numDistinct2("aaa", "aa"));
    System.out.println(d.numDistinct2("aaa", "aaa"));
    System.out.println(d.numDistinct2("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
  }
}
