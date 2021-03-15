// Given an integer array nums, find the contiguous subarray (containing at least one 
// number) which has the largest sum and return its sum.

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int currSum = 0;
    for (int i=0; i<nums.length; i++) {
      currSum += nums[i];
      if (currSum < 0)
        currSum = 0;
      max = Math.max(max, currSum);
    }

    return max;
  }

  public static void Run() {
    MaximumSubarray s = new MaximumSubarray();
    System.out.println(s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    System.out.println(s.maxSubArray(new int[]{1}));
    System.out.println(s.maxSubArray(new int[]{5,4,-1,7,8}));
  }
}
