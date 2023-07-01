// Given a string s, reverse only all the vowels in the string and return it.
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

public class ReverseVowels {
  public String reverseVowels(String s) {
    char[] result = s.toCharArray();
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (!isVowel(result[left]) && left < right) {
        left++;
      }
      while (!isVowel(result[right]) && left < right) {
        right--;
      }
        
      if (left < right) {
        char temp = result[left];
        result[left] = result[right];
        result[right] = temp;
        left++;
        right--;
      }
    }
    return String.valueOf(result);     
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
      || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
  }

  public static void Run() {
    ReverseVowels r = new ReverseVowels();
    System.out.println(r.reverseVowels("hello"));
    System.out.println(r.reverseVowels("hhllo"));
    System.out.println(r.reverseVowels("haah"));
    System.out.println(r.reverseVowels("hlelh"));
    System.out.println(r.reverseVowels("hllh"));
    System.out.println(r.reverseVowels("hlklh"));
    System.out.println(r.reverseVowels("o"));
    System.out.println(r.reverseVowels("aa"));
    System.out.println(r.reverseVowels("aeiou"));
  }
}
