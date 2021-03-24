// Given an array of non-negative integers nums, you are initially positioned at the 
// first index of the array.
// Each element in the array represents your maximum jump length at that position.
// Determine if you are able to reach the last index.

public class JumpGame {
  public boolean canJump(int[] nums) {
    // sentinel marks the smallest index from where we can reach the goal line.
    int sentinel = Integer.MAX_VALUE;
    if (nums.length == 1)
      return true;
    for (int i=nums.length-2; i>=0; i--) {
      // we do Math.min just to take care of the first assignment to sentinel when it's still MAX_VALUE
      if (nums[i] + i >= Math.min(nums.length-1, sentinel))
        sentinel = i;
    } 
    
    // we found the smallest sentinel, let's see if we can reach it from position 0
    return nums[0] >= sentinel;
  }

  public static void Run() {
    JumpGame j = new JumpGame();
    System.out.println(j.canJump(new int[]{2,3,1,1,4}));
    System.out.println(j.canJump(new int[]{3,2,1,0,4}));
  }
}
