// You are given an integer array nums of length n.
// Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as 
// follow:
// F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
// Return the maximum value of F(0), F(1), ..., F(n-1).
// The test cases are generated so that the answer fits in a 32-bit integer.

public class RotateFunction {
  // Observe:
  // F(0) = nums[0] * 0 + nums[1] * 1 + nums[2] * 2 + ... + nums[n-1] * (n-1)
  // F(1) =               nums[0] * 1 + nums[1] * 2 +     + nums[n-2] * (n-1) + nums[n-1] * 0
  // So essentially, from F(0) to F(1), we added sum(nums) except for nums[n-1], and then we also subtracted nums[n-1] * (n-1)
  // So F(1) = F(0) + sum(nums) - nums[n-1] * n
  // We keep doing this for n - 1 times. Notice each time the current nums[n-1] is actually nums[i] where i = n-1, n-2, ... , 1
  public int maxRotateFunction(int[] nums) {
    int result = 0;
    int arraySum = 0;
    for (int i=0; i<nums.length; i++) {
      result += i * nums[i];
      arraySum += nums[i];
    }
    
    int currSum = result;
    for (int i=nums.length-1; i>=1; i--) {
      currSum = currSum + arraySum - nums[i] * nums.length;
      result = Math.max(result, currSum);
    }
    return result;
  }

  public static void Run() {
    RotateFunction solution = new RotateFunction();
    int[] nums = {4, 3, 2, 6};
    System.out.println("Maximum rotation function value: " + solution.maxRotateFunction(nums));
  }
}
