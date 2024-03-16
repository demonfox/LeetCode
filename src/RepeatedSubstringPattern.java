public class RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern(String s) {
    if (s.length() == 1)
      return false;

    for (int i=0; i <= (s.length()-2)/2; i++) {
      String currStr = s.substring(0, i+1);
      int currLen = i+1;
      int j;
      for (j=i+1; j<=(s.length() - currLen); j+=currLen) {
        if (!currStr.equals(s.substring(j, j+currLen)))
          break;
      }
      if (j == s.length())
        return true;
    }
    return false;
  }

  public boolean repeatedSubstringPattern2(String s) {
    String doubled = s + s;
    String sub = doubled.substring(1, doubled.length() - 1);
    return sub.contains(s);
  }

  public static void Run() {
    RepeatedSubstringPattern r = new RepeatedSubstringPattern();
    System.out.println(r.repeatedSubstringPattern("abab"));
    System.out.println(r.repeatedSubstringPattern("ababab"));
    System.out.println(r.repeatedSubstringPattern("ababa"));
    System.out.println(r.repeatedSubstringPattern("abcabcabcabc"));
    System.out.println(r.repeatedSubstringPattern("abcabc"));
  }
}
