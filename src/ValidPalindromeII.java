// Given a string s, return true if the s can be palindrome after deleting at most one character from it.

public class ValidPalindromeII {
  public boolean validPalindrome(String s) {
    if (s.length() == 1)
      return true;
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      char c1 = s.charAt(i);
      char c2 = s.charAt(j);
      if (c1 != c2) {
        boolean result = innerLoop(s, i+1, j);
        if (result == true)
          return result;
        else
          result = innerLoop(s, i, j-1);
        return result;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  private boolean innerLoop(String s, int i, int j) {
    while (i < j) {
      char c1 = s.charAt(i);
      char c2 = s.charAt(j);
      if (c1 != c2) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  public static void Run() {
    ValidPalindromeII p = new ValidPalindromeII();
    System.out.println(p.validPalindrome("aba"));
    System.out.println(p.validPalindrome("abca"));
    System.out.println(p.validPalindrome("abc"));
  }
}
