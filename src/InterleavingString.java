// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
// An interleaving of two strings s and t is a configuration where s and t are divided into n 
// and m substrings respectively, such that:
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of strings a and b.

public class InterleavingString {

  // backtracking; it works but it's too slow
  public boolean isInterleave1(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length())
      return false;
    boolean result = helper(s1, 0, s2, 0, s3, 0, 1);
    if (result) return true;
    return helper(s1, 0, s2, 0, s3, 0, 2);
  }

  private boolean helper(String s1, int start1, String s2, int start2, String s3, int start3, int s1ors2) {
    if (s1ors2 == 1) {
      if (start2 == s2.length())
        return s1.substring(start1).equals(s3.substring(start3));
    } else {
      if (start1 == s1.length())
        return s2.substring(start2).equals(s3.substring(start3));
    }

    String s = (s1ors2 == 1) ? s1 : s2;
    int start = (s1ors2 == 1) ? start1 : start2;

    for (int i=start; i<s.length() && start3<s3.length(); i++, start3++) {
      if (s3.charAt(start3) != s.charAt(i))
        return false;
      if (s1ors2 == 1) {
        if (helper(s1, i+1, s2, start2, s3, start3+1, 2))
          return true;
      } else {
        if (helper(s1, start1, s2, i+1, s3, start3+1, 1))
          return true;
      }
    }
    return false;
  }

  // using Dynamic Programming
  // define a state transition function DP[i][j], where:
  // DP[i][j] = true, if DP[i][j-1] == true && s1's current character == s3's current character
  //                  or DP[i-1][j] == true && s2's current character == s3's current character
  // if you think about how DP[1][1] is determined, it will become relatively obvious <-- think about it
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length())
      return false;
      
    boolean[][] DP = new boolean[s2.length()+1][s1.length()+1];
    DP[0][0] = true;
    for (int j=1; j<s1.length()+1; j++)
      DP[0][j] = DP[0][j-1] && (s3.charAt(j-1) == s1.charAt(j-1));
    for (int i=1; i<s2.length() + 1; i++)
      DP[i][0] = DP[i-1][0] && (s3.charAt(i-1) == s2.charAt(i-1));
    
    for (int i=1; i<s2.length()+1; i++) {
      for (int j=1; j<s1.length()+1; j++) {
        DP[i][j] = (DP[i][j-1] && (s3.charAt(i+j-1) == s1.charAt(j-1))) || (DP[i-1][j] && (s3.charAt(i+j-1) == s2.charAt(i-1)));
      }
    }

    return DP[s2.length()][s1.length()];
  }

  public static void Run() {
    InterleavingString solution = new InterleavingString();
    System.out.println(solution.isInterleave("abc", "def", "adbecf"));
    System.out.println(solution.isInterleave1("abc", "def", "adbecf"));
    System.out.println(solution.isInterleave("abc", "def", "daebfc"));
    System.out.println(solution.isInterleave1("abc", "def", "daebfc"));
    System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    System.out.println(solution.isInterleave1("aabcc", "dbbca", "aadbbcbcac"));
    System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    System.out.println(solution.isInterleave1("aabcc", "dbbca", "aadbbbaccc"));
    System.out.println(solution.isInterleave1("aaaa", "aa", "aaa"));
    System.out.println(solution.isInterleave1("aaaa", "aa", "aaa"));
  }
}
