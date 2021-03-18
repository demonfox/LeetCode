// Given two strings s and t, return the minimum window in s which will contain all the characters 
// in t. If there is no such window in s that covers all characters in t, return the empty string "".
// Note that If there is such a window, it is guaranteed that there will always be only one unique 
// minimum window in s.

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

public class MinWindowSubstring {
  public String minWindow(String s, String t) {
    // 1. Build a map for all chars in t with their counts
    // 2. Scan s for all characters that are in t, and record their positions in filteredS
    // 3. Iterate through filteredS and keep a count of all characters found in the current window
    // 4. If one character has appeared enough times as required, we record that we have *found* one character
    // 5. Repeat 4 until all characters are found in the current window
    // 6. Now shrink the window by moving the left pointer until one character no longer meets the required count.
    //    If the size of the window ever shrinks to be less than the current minimum window size, then update the result
    // 7. Repeat Step 3 until we reach the end of filteredS
    Map<Character, Integer> required = new HashMap<Character, Integer>();
    for (int i=0; i<t.length(); i++) {
      int count = required.getOrDefault(t.charAt(i), 0);
      required.put(t.charAt(i), count+1);
    }

    ArrayList<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
    for (int i=0; i<s.length(); i++) {
      if (required.containsKey(s.charAt(i))) {
        filteredS.add(new Pair<Integer, Character>(i, s.charAt(i)));
      }
    }

    Map<Character, Integer> windowCount = new HashMap<Character, Integer>();
    int found = 0;
    int[] answer = new int[]{-1, -1, 0};
    int left = 0;
    int right = 0;
    for(; right<filteredS.size(); right++) {
      char c = filteredS.get(right).getValue();
      int count = windowCount.getOrDefault(c, 0);
      windowCount.put(c, count+1);
      if ((count + 1) == required.get(c))
        found++;

      while (left <= right && found == required.size()) {
        c = filteredS.get(left).getValue();
        int start = filteredS.get(left).getKey();
        int end  = filteredS.get(right).getKey(); // actually right is not changing in this loop
        if (answer[0] == -1 || answer[2] > end - start + 1) {
          answer[0] = start;
          answer[1] = end;
          answer[2] = end - start + 1;
        }
        count = windowCount.get(c);
        windowCount.put(c, count-1);
        if ((count-1) < required.get(c))
          found--;
        left++;
      }
    }

    return (answer[2] == 0) ? "" : s.substring(answer[0], answer[1]+1);
  }

  public static void Run() {
    MinWindowSubstring m = new MinWindowSubstring();
    System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
  }
}
