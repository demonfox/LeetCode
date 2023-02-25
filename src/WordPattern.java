// Given a pattern and a string s, find if s follows the same pattern.
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

import java.util.HashSet;

public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ", 0);
    if (pattern.length() != words.length)
      return false;

    String[] matches = new String[26]; // since pattern contains only lower-case English letters
    for (int i=0; i<26; i++)
      matches[i] = "";
  
    HashSet<String> wordDict = new HashSet<String>();
    
    for (int i=0; i<pattern.length(); i++) {
      int index = pattern.charAt(i) - 'a';
      if (matches[index].equals("")) {
        if (wordDict.contains(words[i])) // this means the same word is now mapping to 2 different pattern letters
          return false;

        matches[index] = words[i];
        wordDict.add(words[i]);
      } else {
        if (!matches[index].equals(words[i]))
          return false;
      }
    }
    return true;
  }

  public static void Run() {
    WordPattern w = new WordPattern();
    System.out.println(w.wordPattern("abba", "dog cat cat dog"));
    System.out.println(w.wordPattern("abba", "dog cat cat fish"));
    System.out.println(w.wordPattern("aaaa", "dog cat cat dog"));
    System.out.println(w.wordPattern("abba", "dog dog dog dog"));

  }
}
