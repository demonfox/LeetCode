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
    // generate a test case for reverseWords
    ReverseWordsInString r = new ReverseWordsInString();
    System.out.println(r.reverseWords("Let's take LeetCode contest"));
    System.out.println(r.reverseWords("Mr Ding"));
  }
}
