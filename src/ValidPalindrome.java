// Given a string s, determine if it is a palindrome, considering only alphanumeric characters 
// and ignoring cases.
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s.length() == 1)
      return true;
    int i = 0;
    int j = s.length()-1;
    while (i < j) {
      char c1 = s.charAt(i);
      char c2 = s.charAt(j);
      if (!Character.isLetterOrDigit(c1))
        i++;
      else if (!Character.isLetterOrDigit(c2))
        j--;
      else if (Character.toLowerCase(c1) != Character.toLowerCase(c2))
        return false;
      else {
        i++;
        j--;
      }
    }
    return true;
  }
  
  public static void Run() {
    ValidPalindrome p = new ValidPalindrome();
    System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(p.isPalindrome("race a car"));
  }
}
