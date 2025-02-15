// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class MinSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    if (nums.length == 1) return (nums[0] >= target ? 1 : 0);

    int minLength = Integer.MAX_VALUE;
    int lastSum = 0;
    int lastJIndex = 0;
    for (; lastJIndex<nums.length; lastJIndex++) {
      lastSum += nums[lastJIndex];
      if (lastSum >= target) {
        minLength = lastJIndex + 1;
        break;
      }
    }

    for (int i=1; i<nums.length; i++) {
      if (nums[i] >= target) return 1;
      int sum = lastSum - nums[i-1];
      if (sum >= target) {
        minLength = Math.min(lastJIndex - i + 1, minLength);
        lastSum -= nums[i-1];
        continue;
      }
      int j;
      for (j=lastJIndex+1; j<nums.length; j++) {
        sum += nums[j];
        if (sum >= target) {
          minLength = Math.min(j - i + 1, minLength);
          lastJIndex = j;
          lastSum = sum;
          break;
        }
      }
      if (j == nums.length) break; 
    }

    return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
  }

  public static void Run() {
    MinSizeSubarraySum m = new MinSizeSubarraySum();
    System.out.println(m.minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    System.out.println(m.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1,1,1}));
    System.out.println(m.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    System.out.println(m.minSubArrayLen(4, new int[]{1,4,4}));
  }
}
