// Given two strings text1 and text2, return the length of their longest common subsequence. 
// If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string with some 
// characters (can be none) deleted without changing the relative order of the remaining characters.
// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] LCS = new int[m+1][n+1];
    for (int i=0; i<m+1; i++)
      LCS[i][0] = 0;
    for (int j=0; j<n+1; j++)
      LCS[0][j] = 0;
    for (int i=1; i<m+1; i++) {
      for (int j=1; j<n+1; j++) {
        if (text1.charAt(i-1) == text2.charAt(j-1)) {
          LCS[i][j] = LCS[i-1][j-1]+1;
        } else {
          LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
        }
      }
    }

    sb.setLength(0);
    recon(text1, text2, LCS, m, n);
    return LCS[m][n];
  }

  public StringBuilder sb = new StringBuilder();
  private void recon(String text1, String text2, int[][] lcs, int i, int j) {
    if (lcs[i][j] == 0)
      return;
    if (text1.charAt(i-1) == text2.charAt(j-1)) {
      sb.insert(0, text1.charAt(i-1));
      recon(text1, text2, lcs, i-1, j-1);
    } else {
      if (lcs[i-1][j] > lcs[i][j-1])
        recon(text1, text2, lcs, i-1, j);
      else
        recon(text1, text2, lcs, i, j-1);
    }
  }

  public static void Run() {
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    System.out.println("LCS is " + lcs.longestCommonSubsequence("abcde", "ace") + " " + lcs.sb.toString());
  }
}
