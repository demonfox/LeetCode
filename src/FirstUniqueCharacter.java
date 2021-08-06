// Given a string s, find the first non-repeating character in it and 
// return its index. If it does not exist, return -1.

public class FirstUniqueCharacter {
  public int firstUniqChar(String s) {
    // the constraint is s consists of only lowercase English letters.
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++)
      count[s.charAt(i) - 'a']++;
    for (int i = 0; i < s.length(); i++)
      if (count[s.charAt(i) - 'a'] == 1)
        return i;
    return -1;
  }

  public static void Run() {
    FirstUniqueCharacter f = new FirstUniqueCharacter();
    System.out.println(f.firstUniqChar("leetcode"));
    System.out.println(f.firstUniqChar("loveleetcode"));
    System.out.println(f.firstUniqChar("aabb"));
  }
}
