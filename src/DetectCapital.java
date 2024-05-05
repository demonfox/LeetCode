// We define the usage of capitals in a word to be right when one of the following cases holds:
// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.

public class DetectCapital {
  public boolean detectCapitalUse(String word) {
    boolean firstLetterIsCapital = (word.charAt(0) >= 65 && word.charAt(0) <= 90);
    int capitalLetterCount = (firstLetterIsCapital) ? 1 : 0;
    for (int i=1; i<word.length(); i++) {
      if (word.charAt(i) >= 65 && word.charAt(i) <= 90)
        capitalLetterCount++;
    }
    return (firstLetterIsCapital && capitalLetterCount == 1) || capitalLetterCount == word.length() || capitalLetterCount == 0;
  }

  public static void Run() {
    DetectCapital dc = new DetectCapital();
    System.out.println(dc.detectCapitalUse("USA"));
    System.out.println(dc.detectCapitalUse("leetcode"));
    System.out.println(dc.detectCapitalUse("Google"));
    System.out.println(dc.detectCapitalUse("FlaG"));
    System.out.println(dc.detectCapitalUse("flaG"));
    System.out.println(dc.detectCapitalUse("g"));
  }
}
