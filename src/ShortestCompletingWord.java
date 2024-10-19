// Given a string licensePlate and an array of strings words, find the shortest completing word in words.
// A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in 
// licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, 
// then it must appear in the word the same number of times or more.
// For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. 
// Possible completing words are "abccdef", "caaacab", and "cbca".
// Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple 
// shortest completing words, return the first one that occurs in words.

import java.util.Arrays;
import java.util.Comparator;

public class ShortestCompletingWord {
  class WordWithLength {
    public String word;
    public int length;
  }
  public String shortestCompletingWord(String licensePlate, String[] words) {
    WordWithLength[] wwl = new WordWithLength[words.length];
    for (int i=0; i<words.length; i++) {
      wwl[i] = new WordWithLength();
      wwl[i].word = words[i];
      wwl[i].length = words[i].length();
    }
    Arrays.sort(wwl, new Comparator<WordWithLength>() {
      @Override
      public int compare(WordWithLength o1, WordWithLength o2) {
        return Integer.compare(o1.length, o2.length);
      }
    });

    int[] charCount = new int[26];
    for (int i=0; i<licensePlate.length(); i++) {
      char c = licensePlate.charAt(i);
      if (c >= 'a' && c <= 'z')
        charCount[c - 'a']++;
      else if (c >= 'A' && c <= 'Z')
        charCount[c - 'A']++;
    }

    for (WordWithLength w : wwl) {
      if (isComplete(Arrays.copyOf(charCount, charCount.length), w.word)) {
        return w.word;
      }
    }
    return "";
  }

  private boolean isComplete(int[] count, String word) {
    for (int i=0; i<word.length(); i++) {
      char c = word.charAt(i);
      count[c - 'a']--;
    }
    for (int n : count) {
      if (n > 0)
        return false;
    }
    return true;
  }

  public static void Run() {
    String licensePlate = "1s3 PSt";
    String[] words = {"step","steps","stripe","stepple"};
    System.out.println(new ShortestCompletingWord().shortestCompletingWord(licensePlate, words));
    licensePlate = "1s3 456";
    words = new String[] {"looks", "pest", "stew", "show"};
    System.out.println(new ShortestCompletingWord().shortestCompletingWord(licensePlate, words));
  }
}
