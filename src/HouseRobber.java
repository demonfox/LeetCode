// You are a professional robber planning to rob houses along a street. Each house has a certain 
// amount of money stashed, the only constraint stopping you from robbing each of them is that 
// adjacent houses have security systems connected and it will automatically contact the police 
// if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum 
// amount of money you can rob tonight without alerting the police.

public class HouseRobber {
  // using Dynamic Programming
  public int rob(int[] nums) {
    // Define a state transition function DP[i] as: the maximum value you can rob when you get to house i
    // Now when we look at DP[i], let's think about what happened at house i-1
    // 1) we have robbed i-1, which means, we cannot rob house i, so DP[i] = DP[i-1]
    // 2) we have not robbed i-1, which means, we should always rob house i to maximize our profit, and
    //    thus DP[i] = DP[i-2] + nums[i]
    // So combining these two factors, we have:
    // DP[i] = max(DP[i-1], DP[i-2] + nums[i])
    if (nums.length == 1)
      return nums[0];
    else if (nums.length == 2)
      return Math.max(nums[0], nums[1]);

    // int[] DP = new int[nums.length];
    // DP[0] = nums[0];
    // DP[1] = Math.max(nums[0], nums[1]);
    // for (int i=2; i<m; i++) {
    //   DP[i] = Math.max(DP[i-1], DP[i-2]+nums[i]);
    // }
    
    // well, I am just kidding. If you think about it, you don't really need an array. We just need 3 variables.
    int x = nums[0];
    int y = Math.max(nums[0], nums[1]);
    for (int i=2; i<nums.length; i++) {
      int temp = Math.max(y, x+nums[i]);
      x = y;
      y = temp;
    }
    
    return y;
  }

  public static void Run() {
    HouseRobber h = new HouseRobber();
    System.out.println(h.rob(new int[]{1,2,3,1}));
    System.out.println(h.rob(new int[]{2,7,9,3,1}));
    System.out.println(h.rob(new int[]{2,7,9,3,1,3}));
  }
}
