// Write a function that reverses a string. The input string is given as an array of characters s.
// Example 1:
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
//
// Example 2:
// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

public class ReverseString {
  public void reverseString(char[] s) {
    int l = 0;
    int r = s.length - 1;
    while (l < r) {
      char temp = s[l];
      s[l] = s[r];
      s[r] = temp;
      l++;
      r--;
    }
  }

  public static void Run() {
    ReverseString r = new ReverseString();
    char[] input = new char[] {'h', 'e' , 'l', 'l', 'o'};
    r.reverseString(input);
    System.out.println(input);
    input = new char[] {'H', 'a' , 'n', 'n', 'a', 'h'};
    r.reverseString(input);
    System.out.println(input);
  }
}
