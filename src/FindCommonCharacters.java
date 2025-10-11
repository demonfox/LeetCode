// Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). 
// You may return the answer in any order.

import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters {
  public List<String> commonChars(String[] words) {
    List<String> result = new LinkedList<>();
    int[][] count = new int[26][words.length];
    for (int i=0; i<words.length; i++) {
      for (int j=0; j<words[i].length(); j++) {
        count[words[i].charAt(j) - 'a'][i]++;
      }
    }
    for (int i=0; i<26; i++) {
      int charCount = Integer.MAX_VALUE;
      for (int j=0; j<words.length; j++)
        charCount = Math.min(charCount, count[i][j]);
      for (int j=0; j<charCount; j++)
        result.add(String.valueOf((char)('a' + i)));
    }
    return result;
  }

  public static void Run() {
    FindCommonCharacters fcc = new FindCommonCharacters();
    String[] words = {"bella","label","roller"};
    System.out.println(fcc.commonChars(words));

    words = new String[] {"cool","lock","cook"};
    System.out.println(fcc.commonChars(words));
  }
}

