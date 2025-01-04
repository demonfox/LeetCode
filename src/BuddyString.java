// Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
// Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
// For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

public class BuddyString {
  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) return false;
    int diff1 = -1, diff2 = -1;
    char[] set = new char[26];
    boolean hasSameLetter = false;
    for (int i=0; i<s.length(); i++) {
      if ((s.charAt(i) != goal.charAt(i))) {
        if (diff1 == -1)
          diff1 = i;
        else if (diff2 == -1)
          diff2 = i;
        else
          return false;
      }
      if (!hasSameLetter) {
        if (set[s.charAt(i) - 'a'] == 1)
          hasSameLetter = true;
        else
          set[s.charAt(i) - 'a'] = 1;
      }
    }
    if (diff1 == -1) // s and goal are the same, so they are buddy strings as long as there are repeated letters that can be swapped
      return hasSameLetter;
    else if (diff2 == -1) // there is only 1 letter that is different, so they cannot be buddy strings
      return false;
    else
      return s.charAt(diff1) == goal.charAt(diff2) && s.charAt(diff2) == goal.charAt(diff1);
  }

  public static void Run() {
    BuddyString bs = new BuddyString();
    System.out.println(bs.buddyStrings("ab", "ba"));
    System.out.println(bs.buddyStrings("ab", "ab"));
    System.out.println(bs.buddyStrings("aa", "aa"));
    System.out.println(bs.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    System.out.println(bs.buddyStrings("aaaaaaabc", "aaaaaaabc"));
    System.out.println(bs.buddyStrings("", "aa"));
  }
}
