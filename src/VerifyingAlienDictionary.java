// In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. 
// The order of the alphabet is some permutation of lowercase letters.
// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only 
// if the given words are sorted lexicographically in this alien language.

import java.util.Comparator;
import java.util.HashMap;

public class VerifyingAlienDictionary {
  private class AlienComparator implements Comparator<String> {
    private HashMap<Character, Integer> alphabet = new HashMap<>();
    public AlienComparator(String order) {
      for (int i=0; i<order.length(); i++)
        alphabet.put(order.charAt(i), i);
    }
    @Override
    public int compare(String s1, String s2) {
      if(s1.length() == s2.length()) {
        for (int i=0; i<s1.length(); i++) {
          if (s1.charAt(i) == s2.charAt(i))
            continue;
          if (alphabet.get(s1.charAt(i)) > alphabet.get(s2.charAt(i)))
            return 1;
          else 
            return -1;
        }
        return 0;
      } else if (s1.length() < s2.length()) {
        for (int i=0; i<s1.length(); i++) {
          if (s1.charAt(i) == s2.charAt(i))
            continue;
          if (alphabet.get(s1.charAt(i)) > alphabet.get(s2.charAt(i)))
            return 1;
          else 
            return -1;
        }
        return -1;
      } else {
        for (int i=0; i<s2.length(); i++) {
          if (s1.charAt(i) == s2.charAt(i))
            continue;
          if (alphabet.get(s1.charAt(i)) > alphabet.get(s2.charAt(i)))
            return 1;
          else
            return -1;
        }
        return 1;
      }
    }
  }

  public boolean isAlienSorted(String[] words, String order) {
    Comparator<String> comparator = new AlienComparator(order);
    for (int i=0; i<words.length-1; i++) {
      if (comparator.compare(words[i], words[i+1]) > 0)
        return false;
    }
    return true;
  }

  public static void Run() {
    String[] words = {"hello","leetcode"};
    String order = "hlabcdefgijkmnopqrstuvwxyz";
    VerifyingAlienDictionary solution = new VerifyingAlienDictionary();
    System.out.println(solution.isAlienSorted(words, order));

    words = new String[] {"word","world","row"};
    order = "worldabcefghijkmnpqstuvxyz";
    System.out.println(solution.isAlienSorted(words, order));

    words = new String[] {"apple","app"};
    order = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(solution.isAlienSorted(words, order));
  }
}
