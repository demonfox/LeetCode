// Given a string s and an integer k, return the length of the longest substring of s such that 
// the frequency of each character in this substring is greater than or equal to k.

import java.util.Arrays;

public class LongestSubstringwithAtLeastK {
  public int longestSubstring(String s, int k) {
    int result = 0;
    int totalUnique = getMaxUniqueChars(s);
    int[] countMap = new int[26];
    // the idea is to find the longest substring wth 1, 2 ... up to totalUnique=T
    // number of characters, the result is the maximum of these T values 
    for (int currUnique = 1; currUnique <= totalUnique; currUnique++) {
      int start = 0, end = 0, uniqueCharInWindow = 0, totalCharAtLeastK = 0;
      Arrays.fill(countMap, 0);
      while (end < s.length()) {
        if (uniqueCharInWindow <= currUnique) {
          int index = s.charAt(end) - 'a';
          if (countMap[index] == 0)
            uniqueCharInWindow++;
          countMap[index]++;
          if (countMap[index] == k)
            totalCharAtLeastK++;
          end++;
        } else {
          int index = s.charAt(start) - 'a';
          if (countMap[index] == k)
            totalCharAtLeastK--;
          countMap[index]--;
          if (countMap[index] == 0)
            uniqueCharInWindow--;
          start++;
        }
        // the idea is, with the current iteration, we are looking for those substring with
        // "currUnique" number of unique characters. 
        // If we have found a window that
        // 1) contains "currUnique" number of unique characters;
        // 2) each of these "currUnique" characters has a count >= k
        // then we update the result with the length of this current window
        // We are strictly looking for windows that contains exactly "currUnique" number
        // of characters in each iteration. This is the key point of this algorithm, that
        // is, for each iteration, we fix how many unique characters we can have in the 
        // substring.  If and only if we have a window that contains exactly that many
        // unique characters and all these characters have >= k appearances will we update
        // the result. 
        // The crucial realization for solving this problem is that we have multiple variables
        // in the solution:
        // 1. the number of unique characters in the substring
        // 2. the appearance of each character in the substring
        // 3. the length of the substring
        // A common mistake when thinking about this problem is trying to deal with all these
        // variables at the same time - you will be very confused and the algorithm will be very
        // messy to think about. So we have to divide up the variables we want to conquer - sort of
        // like fixing one of them (by doing some for loop iteration) and figuring out the value for
        // the other.  Of course, 3 is the actual answer we are looking for so we cannot do much about
        // it. For 1 and 2, the algorithm actually fixes 1 by iterating through all its possible values
        // and then calculates 2 and finally updates 3 once the calculation for 2 meets the right 
        // condition. 
        if (uniqueCharInWindow == currUnique && totalCharAtLeastK == currUnique)
          result = Math.max(end - start, result);
        // notice we are not doing end-start+1 because end or start is already incremented in the if block, 
        // so that accounts for the +1 in the length computation
      }
    }
    return result;
  }

  private int getMaxUniqueChars(String s) {
    boolean[] isCharPresent = new boolean[26];
    int uniqueCount = 0;
    for (int i=0; i<s.length(); i++) {
      if (isCharPresent[s.charAt(i) - 'a'] == false) {
        uniqueCount++;
        isCharPresent[s.charAt(i) - 'a'] = true;
      }
    }
    return uniqueCount;
  }

  public static void Run() {
    LongestSubstringwithAtLeastK l = new LongestSubstringwithAtLeastK();
    System.out.println(l.longestSubstring("aaabb", 3));
    System.out.println(l.longestSubstring("ababbc", 2));
  }
}
