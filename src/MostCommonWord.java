// Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. 
// It is guaranteed there is at least one word that is not banned, and that the answer is unique.
// The words in paragraph are case-insensitive and the answer should be returned in lowercase.

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    paragraph = paragraph.toLowerCase();
    String[] words = paragraph.split("[ !?',;.]+");
    HashSet<String> bannedSet = new HashSet<>();
    for (String w : banned) {
      bannedSet.add(w);
    }
    int maxCount = 0;
    String result = "";
    HashMap<String, Integer> count = new HashMap<>();
    for (String w : words) {
      if (!bannedSet.contains(w)) {
        int newCount = count.getOrDefault(w, 0) + 1;
        count.put(w, newCount);
        if (newCount > maxCount) {
          maxCount = newCount;
          result = w;
        }
      }
    }
    return result;
  }

  public static void Run() {
    String[] banned = new String[] {"hit"};
    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    MostCommonWord mcw = new MostCommonWord();
    System.out.println(mcw.mostCommonWord(paragraph, banned));

    banned = new String[] {"a"};
    paragraph = "a, a, a, a, b, b, b, b, c, c, c";
    System.out.println(mcw.mostCommonWord(paragraph, banned));
  }
}
