// Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length 
// and answer[i] is the distance from index i to the closest occurrence of character c in s.
// The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

import java.util.ArrayList;

public class ShortestDistanceToChar {
  public int[] shortestToChar(String s, char c) {
    ArrayList<Integer> sentinel = new ArrayList<>();
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) == c)
        sentinel.add(i);
    }
    int[] answer = new int[s.length()];
    int sentinelIndexLeft = 0;
    int sentinelIndexRight = 1;
    for (int i=0; i<s.length(); i++) {
      if (i <= sentinel.get(0))
        answer[i] = sentinel.get(sentinelIndexLeft) - i;
      else if (i >= sentinel.get(sentinel.size()-1))
        answer[i] = i - sentinel.get(sentinel.size()-1);
      else {
        answer[i] = Math.min(Math.abs(i - sentinel.get(sentinelIndexLeft)), Math.abs(sentinel.get(sentinelIndexRight) - i));
      }
      if ((sentinelIndexRight < sentinel.size() - 1) && i >= sentinel.get(sentinelIndexRight)) {
        sentinelIndexLeft++;
        sentinelIndexRight++;
      }
    }
    return answer;
  }

  public static void Run() {
    String s = "loveleetcode";
    char c = 'e';
    ShortestDistanceToChar sdtc = new ShortestDistanceToChar();
    int[] answer = sdtc.shortestToChar(s, c);
    for (int i=0; i<answer.length; i++) {
      System.out.print(answer[i] + " ");
    }
    System.out.println();

    s = "abcd";
    c = 'b';
    answer = sdtc.shortestToChar(s, c);
    for (int i=0; i<answer.length; i++) {
      System.out.print(answer[i] + " ");
    }
    System.out.println();

    s = "aaab";
    c = 'b';
    answer = sdtc.shortestToChar(s, c);
    for (int i=0; i<answer.length; i++) {
      System.out.print(answer[i] + " ");
    }
    System.out.println();
  }
}
