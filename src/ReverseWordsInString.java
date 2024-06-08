// Given a string s, reverse the order of characters in each word within a sentence while still preserving 
// whitespace and initial word order.

public class ReverseWordsInString {
  public String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    String[] words = s.split(" ", 0);
    for (String w : words) {
      temp.setLength(0);
      temp.append(w);
      result.append(temp.reverse() + " ");
    }
    result.deleteCharAt(result.length() - 1);
    return result.toString();
  }

  public static void Run() {
    String s = "Let's take LeetCode contest";
    String expected = "s'teL ekat edoCteeL tsetnoc";

    ReverseWordsInString r = new ReverseWordsInString();
    String actual = r.reverseWords(s);
    if (actual.equals(expected)) {
      System.out.println("Test for reverseWords passed.");
    }
  }
}
