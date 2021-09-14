// Given a string s, reverse the string according to the following rules:
// All the characters that are not English letters remain in the same position.
// All the English letters (lowercase or uppercase) should be reversed.
// Return s after reversing it.

public class ReverseOnlyLetters {
  public String reverseOnlyLetters(String s) {
    int l =0, r = s.length() - 1;
    StringBuilder sb = new StringBuilder(s);

    while (l < r) {
      while (!Character.isLetter(s.charAt(l)) && l < r)
        l++;
      while (!Character.isLetter(s.charAt(r)) && l < r)
        r--;
      if (l < r) {
        char c1 = s.charAt(l);
        char c2 = s.charAt(r);
        sb.setCharAt(l, c2);
        sb.setCharAt(r, c1);
        l++;
        r--;
      }
    }
    return sb.toString();
  }

  public static void Run() {
    ReverseOnlyLetters r = new ReverseOnlyLetters();
    System.out.println(r.reverseOnlyLetters("ab-cd"));
    System.out.println(r.reverseOnlyLetters("a-bC-dEf-ghIj"));
    System.out.println(r.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
  }
}
