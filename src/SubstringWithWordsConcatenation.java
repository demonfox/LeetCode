// You are given a string s and an array of strings words. All the strings of words are of the same length.
// A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. 
// "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
// Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithWordsConcatenation {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new ArrayList<>();

    if (words.length == 0 || s.length() == 0) {
      return ans;
    }

    int wordSize = words[0].length();
    int wordCount = words.length;
    int N = s.length();

    HashMap<String, Integer> originalCount = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      originalCount.put(words[i], originalCount.getOrDefault(words[i], 0) + 1);
    }

    for (int offset = 0; offset < wordSize; offset++) {
      HashMap<String, Integer> currentCount = new HashMap<>();
      int start = offset;
      int count = 0;
      for (int end = offset; end + wordSize <= N; end += wordSize) {
        String currWord = s.substring(end, end + wordSize);
        if (originalCount.containsKey(currWord)) {
          currentCount.put(currWord, currentCount.getOrDefault(currWord, 0) + 1);
          count++;

          // Lets say, we encounter currWord in the window more times than it was in the original words array. 
          // Thus, in our window map currentCount the count of currWord is more than its respective count in the 
          // map originalCount. Well we just shorten the window from the left and every word we encounter, we 
          // respectively decrement its count by 1 from currentCount map. We shorten the window and do this whole 
          // operation until the count of currWord is same in both the maps.
          while (currentCount.get(currWord) > originalCount.get(currWord)) {
            String startWord = s.substring(start, start + wordSize);
            currentCount.put(startWord, currentCount.get(startWord) - 1);
            start += wordSize;
            count--;
          }

          if (count == wordCount) {
            ans.add(start);
          }

        } else {
          count = 0;
          start = end + wordSize;
          currentCount.clear();
        }
      }

    }
    return ans;
  }

  // This is easy to understand but gives TLE on the input a string of 10000 'a' and 5000 words of 'a'
  // so we need a more efficient solution
  public List<Integer> findSubstring1(String s, String[] words) {
    HashMap<String, Integer> freq = new HashMap<>();
    for (String w : words)
      freq.merge(w, 1, (oldValue, value) -> oldValue + 1);
    
    int wordCount = words.length;
    int wordSize = words[0].length();
    int windowSize = wordSize * wordCount;
    List<Integer> result = new LinkedList<>();

    for (int startPos = 0; startPos < wordSize; startPos++) {
      int start = startPos;
      while ((start + windowSize) - 1 < s.length()) {
        HashMap<String, Integer> currMap = new HashMap<>(freq);
        String currWord;
        boolean matched = true;
        for (int i = 0; i < wordCount; i++) {
          currWord = s.substring(start + i*wordSize, start + i*wordSize + wordSize);
          if (!currMap.containsKey(currWord) || currMap.get(currWord) == 0) {
            matched = false;
            break;
          }
          currMap.put(currWord, currMap.get(currWord)-1);
        }
        if (matched)
          result.add(start);
        start += wordSize;
      }
    }

    return result;
  }

  public static void Run() {
    SubstringWithWordsConcatenation s = new SubstringWithWordsConcatenation();
    System.out.println(s.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
    System.out.println(s.findSubstring("a", new String[] {"a","a"}));
  }
}
