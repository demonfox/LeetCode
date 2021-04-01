// Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where 
// each word is a valid dictionary word. Return all such possible sentences in any order.
// Note that the same word in the dictionary may be reused multiple times in the segmentation.

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
  List<String> result;
  public List<String> wordBreak(String s, List<String> wordDict) {
    result = new LinkedList<>();
    Set<String> dict = new HashSet<String>(wordDict);
    helper(s, 0, dict, new HashSet<>(), "");
    return result;
  }
 
  private boolean helper(String s, int start, Set<String> dict, Set<String> badStrings, String ans) {
    if (start == s.length()) {
      result.add(ans.substring(0, ans.length()-1)); // remove the whitespace at the end
      return true;
    }
    if (badStrings.contains(s))
      return false;

    boolean isGoodString = false;
    for (int i=start+1; i<=s.length(); i++) {
      String subString = s.substring(start, i);
      if (dict.contains(subString)) {
        if (helper(s, i, dict, badStrings, ans + subString + " "))
          isGoodString = true;
      }
    }
    
    if (!isGoodString)
      badStrings.add(s.substring(start));

    return isGoodString;
  }

  public static void Run() {
    WordBreakII w = new WordBreakII();
    List<String> result = w.wordBreak("catsanddog", new LinkedList<String>(Arrays.asList("cats","dog","sand","and","cat")));
    result.forEach(s -> System.out.println(s));
    result = w.wordBreak("pineapplepenapple", new LinkedList<String>(Arrays.asList("apple","pen","applepen","pine","pineapple")));
    result.forEach(s -> System.out.println(s));
    result = w.wordBreak("catsandog", new LinkedList<String>(Arrays.asList("cats","dog","sand","and","cat")));
    result.forEach(s -> System.out.println(s));
  }
}
