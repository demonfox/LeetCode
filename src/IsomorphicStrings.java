// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order 
// of characters. No two characters may map to the same character, but a character may map to itself.

import java.util.Arrays;

public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    int[] sMap = new int[128];
    int[] tMap = new int[128];
    Arrays.fill(sMap, -1);
    Arrays.fill(tMap, -1);

    for (int i=0; i<s.length(); i++) {
      int sIdx = (int)s.charAt(i);
      int tIdx = (int)t.charAt(i);
      if (sMap[sIdx] != -1) {
        if (sMap[sIdx] != tIdx)
          return false;
      } else {
        if (tMap[tIdx] != -1) {
          // another character already maps to the current character in t
          return false;
        } else {
          sMap[sIdx] = tIdx;
          tMap[tIdx] = sIdx;
        }
      }
    }
    return true;
  }

  public static void Run() {
    IsomorphicStrings i = new IsomorphicStrings();
    System.out.println(i.isIsomorphic("egg", "add"));
    System.out.println(i.isIsomorphic("foo", "bar"));
    System.out.println(i.isIsomorphic("paper", "title"));
  }
}
