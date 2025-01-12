// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a 
// single space separating the words. Do not include any extra spaces.

public class ReverseWords {
  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder(s);
    int i = 0, j = sb.length()-1;
    while (i < j) {
      char temp = sb.charAt(i);
      sb.setCharAt(i, sb.charAt(j));
      sb.setCharAt(j, temp);
      i++; j--;
    }

    // trimming the leading and trailing spaces
    i = 0;
    while (i < sb.length() && sb.charAt(i) == ' ') {
      i++;
    }
    j = sb.length() - 1;
    while (j > i && sb.charAt(j) == ' ') {
      j--;
    }
    
    sb.delete(j + 1, sb.length());
    sb.delete(0, i);

    i = 0;
    int k;
    for (; i<sb.length(); ) {
      j = k = sb.indexOf(" ", i); // find the end of the word
      if (j == -1) {
        j = sb.length() - 1;
        k = sb.length();
      }
      else
        j -= 1;
      
      while (i < j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        i++; j--;
      }
      i = k+1;
      // find the start of next word
      while (i<sb.length()) {
        if (sb.charAt(i) != ' ')
          break;
        sb.deleteCharAt(i);
      }
    }
    return sb.toString();
  }

  public static void Run() {
    ReverseWords rw = new ReverseWords();
    String s = "  the   sky is blue  ";
    System.out.println(rw.reverseWords(s));
    s = " hello world ";
    System.out.println(rw.reverseWords(s));
  }
}
