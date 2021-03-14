// Given an integer array nums, return the length of the longest strictly increasing subsequence.
// A subsequence is a sequence that can be derived from an array by deleting some or 
// no elements without changing the order of the remaining elements. 
// For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

import java.util.Arrays;

public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int[] LIS = new int[nums.length];
    Arrays.fill(LIS, 1);
    int result = 1;
    for (int i=1; i<nums.length; i++) {
      for (int j=0; j<i; j++) {
        if (nums[i] > nums[j]) {
          LIS[i] = Math.max(LIS[i], 1+LIS[j]);
        }
      }
      result = Math.max(result, LIS[i]);
    }

    printLIS(nums, LIS);
    return result;
  }

  private void printLIS(int[] nums, int[] LIS) {
    int lis = LIS[0];
    int lisAtIndex = 0;
    for (int i=1; i<LIS.length; i++) {
      if (LIS[i] > lis) {
        lis = LIS[i];
        lisAtIndex = i;
      }
    }

    StringBuilder b = new StringBuilder();
    b.append(nums[lisAtIndex]);
    lis--;
    for (int i=lisAtIndex-1; i>=0; i--) {
      if (LIS[i] == lis) {
        b.insert(0, nums[i] + " ");
        lis--;
      }
    }
    System.out.println(b.toString());
  }

  public static void Run() {
    LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
    System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    System.out.println(s.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    System.out.println(s.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
  }
}
