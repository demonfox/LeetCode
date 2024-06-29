// We define a harmonious array as an array where the difference between its maximum value and its 
// minimum value is exactly 1.
// Given an integer array nums, return the length of its longest harmonious subsequence among all 
// its possible subsequences.

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
  public int findLHS(int[] nums) {
    Arrays.sort(nums);
    int currMin, currLen, maxLen, minValLen;
    currMin  = nums[0];
    currLen = minValLen = 1;
    maxLen = 0;
    for (int i=1; i<nums.length; i++) {
      if (nums[i] == currMin) {
        currLen++;
        minValLen++;
      } else if (nums[i] == currMin + 1) {
        currLen++;
      } else {
        if (currLen > minValLen)
          maxLen = Math.max(maxLen, currLen);
        if ((nums[i] == currMin + 2) && (currLen > minValLen)) {
          currMin = currMin + 1;
          currLen -= minValLen;
          minValLen = currLen;
          currLen++; // we need to count in the current number
        } else {
          currMin = nums[i];
          currLen = minValLen = 1;
        }
      }
    }

    if (currLen > minValLen)
      maxLen = Math.max(maxLen, currLen);
    return maxLen;
  }

  public static void Run() {
    LongestHarmoniousSubsequence lhs = new LongestHarmoniousSubsequence();
    System.out.println(lhs.findLHS(new int[]{1, 1, 1, 1}));
    System.out.println(lhs.findLHS(new int[]{1, 2, 3, 4, 5, 6, 6, 6, 7, 7}));
    System.out.println(lhs.findLHS(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 3, 4}));
    System.out.println(lhs.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
  }
}
