// In a string s of lowercase letters, these letters form consecutive groups of the same character.
// For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
// A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of 
// the group. In the above example, "xxxx" has the interval [3,6].
// A group is considered large if it has 3 or more characters.
// Return the intervals of every large group sorted in increasing order by start index.

import java.util.LinkedList;
import java.util.List;

public class LargeGroupPositions {
  public List<List<Integer>> largeGroupPositions(String s) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    for (int i=0; i<s.length();) {
      char sentinel = s.charAt(i);
      int start = i++;
      while (i < s.length()) {
        if (sentinel != s.charAt(i))
          break;
        i++;
      }
      if ((i - start) >= 3) {
        List<Integer> group = new LinkedList<>();
        group.add(start);
        group.add(i-1);
        result.add(group);
      }
    }
    return result;
  }

  public static void Run() {
    LargeGroupPositions lgp = new LargeGroupPositions();
    String s = "abbxxxxzzy";
    System.out.println(lgp.largeGroupPositions(s));

    s = "abc";
    System.out.println(lgp.largeGroupPositions(s));

    s = "abcdddeeeeaabbbcd";
    System.out.println(lgp.largeGroupPositions(s));
  }
}
