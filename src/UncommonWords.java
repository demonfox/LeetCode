// A sentence is a string of single-space separated words where each word consists only of lowercase letters.
// A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
// Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

import java.util.HashSet;

public class UncommonWords {
  public String[] uncommonFromSentences(String s1, String s2) {
    String[] words = s1.split(" ");
    HashSet<String> qualified = new HashSet<>();
    HashSet<String> disqualified = new HashSet<>();
    for (String word : words) {
      if (!disqualified.contains(word)) {
        if (!qualified.contains(word)) {
          qualified.add(word);
        } else {
          qualified.remove(word);
          disqualified.add(word);
        }
      }
    }
    
    words = s2.split(" ");
    for (String word : words) {
      if (!disqualified.contains(word)) {
        if (!qualified.contains(word)) {
          qualified.add(word);
        } else {
          qualified.remove(word);
          disqualified.add(word);
        }
      }
    }

    return qualified.toArray(new String[qualified.size()]);
  }

  public static void Run() {
    UncommonWords uncommonWords = new UncommonWords();
    String[] words = uncommonWords.uncommonFromSentences("this apple is sweet", "this apple is sour");
    for (String word : words) {
      System.out.println(word);
    }

    words = uncommonWords.uncommonFromSentences("apple apple", "banana");
    for (String word : words) {
      System.out.println(word);
    }
  }
}
