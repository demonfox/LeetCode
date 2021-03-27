// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the 
// shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, Integer> visited = new HashMap<String, Integer>();
    for (String s : wordList)
      visited.put(s, 0);
    if (!visited.containsKey(endWord))
      return 0;

    Queue<String> q = new LinkedList<String>();
    q.add(beginWord);
    visited.put(beginWord, 1);
    q.add(endWord);
    visited.put(endWord, -1); // we will count *negatively* when searching backwards from the endWord

    while (!q.isEmpty()) {
      String currWord = q.remove();
      StringBuilder sb = new StringBuilder(currWord);
      for (int i = 0; i < sb.length(); i++) {
        char currChar = sb.charAt(i);
        for (int j = 0; j < 26; j++) {
          char newChar = (char) ('a' + j);
          if (newChar != currChar) {
            sb.setCharAt(i, newChar);
            if (!visited.containsKey(sb.toString()))
              continue;
            int stepCount = visited.get(sb.toString());
            int currStepCount = visited.get(currWord);
            if (stepCount == 0) {
              // we have not visited this next node, so let's update its stepCount recorded in visited
              if (currStepCount > 0)
                visited.put(sb.toString(), ++currStepCount);
              else
                visited.put(sb.toString(), --currStepCount);
              q.add(sb.toString());
            } else if ((currStepCount > 0 && stepCount < 0) || (currStepCount < 0 && stepCount > 0))
              // we have met in the middle, so return the proper stepCount
              return Math.abs(currStepCount - stepCount);

            // if (sb.toString().equals(endWord))
            // return nextStepCount;
            // else {
            // visited.put(sb.toString(), nextStepCount);
            // q.add(sb.toString());
            // }
          }
        }
        sb.replace(0, sb.length(), currWord);
      }
    }
    return 0;
  }

  public static void Run() {
    WordLadder w = new WordLadder();
    List<String> input = new LinkedList<>();
    input.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    System.out.println(w.ladderLength("hit", "cog", input));
  }
}
