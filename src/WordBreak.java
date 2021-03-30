// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a 
// space-separated sequence of one or more dictionary words.
// Note that the same word in the dictionary may be reused multiple times in the segmentation.

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {

  // Using DP's Bottom-Up approach
  // Define a state function DP[i] as:
  // DP[i] - true if substring of "s" (starting from index 0) with length i is break'able
  // Observe:
  // DP[i+1] can be found by enumerating through all words in wordDict - if the tail of substring
  // s.substring(0,i+1) matches some word and DP[i-word.length()+1] is true, then DP[i+1] is also true.
  // Notice that we don't need to remember how to break down a certain substring, we just need to
  // remember it is break'able.
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] DP = new boolean[s.length()+1];
    DP[0] = true; // if s is empty string, then it's break'able
    for (int i=0; i<s.length(); i++) {
      for (String word : wordDict) {
        // for every word in wordDict, say its length is wLen, we see if the current substring 
        // S[0...i] is composed of S[0...(i-wLen)] and S[(i-wLen+1)...i] - if:
        // 1) DP[i-wLen+1] is true, and
        // 2) S[(i-wLen+1)...i] is equal to word, then we know
        // DP[i] = true
        if (i - word.length() + 1 >= 0) {
          String subString = s.substring(i-word.length()+1, i+1);
          if (subString.equals(word) && DP[i-word.length()+1]) {
            DP[i+1] = true;
            break;
          }
        }
      }
    }
    return DP[s.length()];
  }

  // This is using Top-Down DP approach (i.e. memoization). It works (and I even optimized it 
  // a little by searching for the longest match first) but it can sometimes exceed the time limit.
  public boolean wordBreak2(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<String>(wordDict);
    return helper(s, 0, dict, new HashSet<>());
  }
 
  private boolean helper(String s, int start, Set<String> dict, Set<String> badStrings) {
    if (start == s.length())
      return true;
    if (badStrings.contains(s))
      return false;
    //for (int i=start+1; i<=s.length(); i++) {
    for (int i=s.length(); i>=start+1; i--) {
      String subString = s.substring(start, i);
      if (dict.contains(subString)) {
        if (helper(s, i, dict, badStrings))
          return true;
      }
    }
    // we got here because there is no way to break up "s" starting from index "start", so let'
    // record that in badStrings such that we don't need to check repeatedly look at this particular
    // substring again in the future
    badStrings.add(s.substring(start));
    return false;
  }

  public static void Run() {
    WordBreak w = new WordBreak();
    System.out.println(w.wordBreak("leetcode", new LinkedList<String>(Arrays.asList("leet", "code"))));
    System.out.println(w.wordBreak("applepenapple", new LinkedList<String>(Arrays.asList("apple", "pen"))));
    System.out.println(w.wordBreak("catsandog", new LinkedList<String>(Arrays.asList("cats","dog","sand","and","cat"))));
  }
}
