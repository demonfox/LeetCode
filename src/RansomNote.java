// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters 
// from magazine and false otherwise.
// Each letter in magazine can only be used once in ransomNote.

public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] count = new int[26];
    for (int i = 0; i < magazine.length(); i++)
      count[magazine.charAt(i) - 'a']++;
    for (int i = 0; i < ransomNote.length(); i++) {
      int index = ransomNote.charAt(i) - 'a';
      if (count[index] >= 1) {
        count[index]--;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void Run() {
    RansomNote r = new RansomNote();
    System.out.println(r.canConstruct("a", "b"));
    System.out.println(r.canConstruct("aa", "ab"));
    System.out.println(r.canConstruct("aa", "aab"));
  }
}
