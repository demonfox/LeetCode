// Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
// palindrome that can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.


public class LongestPalindrome {
  public int longestPalindrome(String s) {
    boolean[] flag = new boolean[52];
    int totalLength = 0;
    for (int i=0; i<s.length(); i++) {
      int index = (s.charAt(i) > 'Z') ? s.charAt(i) - 'a' + 26 : s.charAt(i) - 'A';
      if (!flag[index]) {
        flag[index] = true;
      } else {
        flag[index] = false;
        totalLength+=2;
      }
    }
    for (int i=0; i<flag.length; i++) {
      if (flag[i]) {
        totalLength++;
        break;
      }
    }
    return totalLength;
  }

  public static void Run() {
    LongestPalindrome l = new LongestPalindrome();
    System.out.println(l.longestPalindrome("a"));
    System.out.println(l.longestPalindrome("abccccdd"));
  }
}
