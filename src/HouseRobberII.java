// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at 
// this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a 
// security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight 
// without alerting the police.



public class HouseRobberII {
  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    else if (nums.length == 2)
      return Math.max(nums[0], nums[1]);
    else if (nums.length == 3)
      return Math.max(nums[0], Math.max(nums[1],nums[2]));

    // int[] DP = new int[nums.length];
    // Case 1: rob the first house
    // DP[0] = nums[0]
    // DP[1] = 0 - so we cannot rob the second house
    // DP[2] = nums[2] - since DP[1] = 0
    // for (int i=3; i<=nums.length-2; i++) {
    //   DP[i] = Math.max(DP[i-1], DP[i-2]+nums[i]);
    // }
    //
    // Case 2: do not rob the first house
    // DP[0] = 0
    // DP[1] = nums[1]
    // DP[2] = Math.max(nums[1], nums[2])
    // for (int i=3; i<=nums.length-1; i++) {
    //   DP[i] = Math.max(DP[i-1], DP[i-2]+nums[i]);
    // }
    
    // well, I am just kidding. If you think about it, you don't really need an array. We just need 3 variables.

    // Case 1: rob the first house
    int result;
    int x = 0;
    int y = nums[2];
    for (int i=3; i<=nums.length-2; i++) {
      int temp = Math.max(y, x+nums[i]);
      x = y;
      y = temp;
    }
    result = nums[0] + y;

    // Case 2: do not rob the first house
    x = nums[1];
    y = Math.max(nums[1], nums[2]);
    for (int i=3; i<=nums.length-1; i++) {
      int temp = Math.max(y, x+nums[i]);
      x = y;
      y = temp;
    }

    return Math.max(result, y);
  }

  public static void Run() {
    HouseRobberII h = new HouseRobberII();
    System.out.println(h.rob(new int[]{1,2,1,1}));
    System.out.println(h.rob(new int[]{2,3,2}));
    System.out.println(h.rob(new int[]{2,1,1,2}));
    System.out.println(h.rob(new int[]{1,2,3,1}));
    System.out.println(h.rob(new int[]{1,2,3}));
  }
}
