// Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not 
// share common letters. If no such two words exist, return 0.

import java.util.Arrays;

public class MaxProductWordLen {
  public int maxProduct(String[] words) {
    int maxProduct = 0;
    int[] masks = new int[words.length];
    Arrays.sort(words, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
    for (int i=0; i<words.length; i++) {
      for (int j=0; j<words[i].length(); j++) {
        masks[i] |= (1 << words[i].charAt(j) - 'a');
      }
    }

    for (int i=0; i<words.length-1; i++) {
      if (words[i].length() * words[i+1].length() <= maxProduct)
        return maxProduct;
      for (int j=i+1; j<words.length; j++) {
        if ((masks[i] & masks[j]) == 0) {
          if (words[i].length() * words[j].length() > maxProduct) {
            maxProduct = words[i].length() * words[j].length();
            break;
          }
        }
      }
    }
    return maxProduct;
  }

  public static void Run() {
    String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    MaxProductWordLen m = new MaxProductWordLen();
    System.out.println(m.maxProduct(words));

    words = new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
    System.out.println(m.maxProduct(words));

    words = new String[] {"a", "aa", "aaa", "aaaa"};
    System.out.println(m.maxProduct(words));
  }
}
