// Given a string s and an integer k, return the length of the longest substring of s 
// that contains at most k distinct characters
// 1 <= s.length <= 5*10^4
// 0 <= k <= 50

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringwithAtMostK {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k == 0) return 0;

    int start = 0, end = 0, max = 0;
    Map<Character, Integer> charCount = new HashMap<Character, Integer>();
    while (end < s.length()) {
      char curr = s.charAt(end);
      charCount.put(curr, charCount.getOrDefault(curr, 0) + 1);
      
      if (charCount.size() <= k) {
        max = Math.max(max, end - start + 1);
      } else {
        while (start < end) {
          curr = s.charAt(start);
          start++;
          if (charCount.get(curr) == 1) {
            charCount.remove(curr);
            break;
          } else {
            charCount.put(curr, charCount.get(curr) - 1);
          }
        }
      }
      end++;
    }
    return max;
  }

  public static void Run() {
    LongestSubstringwithAtMostK l = new LongestSubstringwithAtMostK();
    System.out.println(l.lengthOfLongestSubstringKDistinct("aa", 1));
    System.out.println(l.lengthOfLongestSubstringKDistinct("bbba", 1));
    System.out.println(l.lengthOfLongestSubstringKDistinct("eceba", 2));
    System.out.println(l.lengthOfLongestSubstringKDistinct("eceba", 1));
    System.out.println(l.lengthOfLongestSubstringKDistinct("aaaaabcdefg", 6));
    System.out.println(l.lengthOfLongestSubstringKDistinct("eceba", 0));
  }
}
