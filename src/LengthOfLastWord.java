// Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
// A word is a maximal substring consisting of non-space characters only.

public class LengthOfLastWord {
  public int lengthOfLastWord1(String s) {
    int currLength = 0;
    int result = 0;
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) != ' ')
        currLength++;
      else {
        if (currLength != 0)
          result = currLength;
        currLength = 0;
      }
    }

    if (currLength != 0)
      return currLength;
    else
      return result;
  }

  public int lengthOfLastWord(String s) {
    String str = s.stripTrailing();
    return str.length() - str.lastIndexOf(' ') - 1;
  }

  public static void Run() {
    LengthOfLastWord l = new LengthOfLastWord();
    System.out.println(l.lengthOfLastWord("Hello World"));
    System.out.println(l.lengthOfLastWord("   fly me   to   the moon  "));
    System.out.println(l.lengthOfLastWord("luffy is still joyboy"));
  }
}
