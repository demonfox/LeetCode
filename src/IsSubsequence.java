// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
// A subsequence of a string is a new string that is formed from the original string by deleting some 
// (can be none) of the characters without disturbing the relative positions of the remaining characters. 
// (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {    
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    return !(i < s.length());
  }

  public static void Run() {
    IsSubsequence s = new IsSubsequence();
    System.out.println(s.isSubsequence("abc", "ahbgdc"));
    System.out.println(s.isSubsequence("axc", "ahbgdc"));
  }
}
