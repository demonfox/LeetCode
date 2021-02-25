// Given two strings s and t , write a function to determine if t is an anagram of s.
// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:
// Input: s = "rat", t = "car"
// Output: false

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i=0; i<t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0)
                return false;
        }
        for (int i=0; i<counter.length; i++) {
            if (counter[i] != 0)
                return false;
        }
        return true;
    }

    public static void Run() {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("", ""));
        System.out.println(v.isAnagram("s", "s"));
        System.out.println(v.isAnagram("st", "sq"));
        System.out.println(v.isAnagram("s", ""));
    }
}
