// Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). 
// The subsequence must be strictly increasing.
// A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], 
// nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

public class LongestContinuousIncreasingSubsequence {
  public int findLengthOfLCIS(int[] nums) {
    int maxLength = 1;
    int currLength = 1;
    for (int i=1; i<nums.length; i++) {
      if (nums[i] > nums[i-1])
        currLength++;
      else {
        maxLength = Math.max(maxLength, currLength);
        currLength = 1;
      }
    }
    return Math.max(maxLength, currLength);
  }

  public static void Run() {
    LongestContinuousIncreasingSubsequence solution = new LongestContinuousIncreasingSubsequence();
    System.out.println(solution.findLengthOfLCIS(new int[]{1,3,5,4,7}));
    System.out.println(solution.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    System.out.println(solution.findLengthOfLCIS(new int[]{1,3,5,7}));
  }
}
