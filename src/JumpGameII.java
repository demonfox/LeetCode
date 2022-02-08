// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at that position.
// Your goal is to reach the last index in the minimum number of jumps.
// You can assume that you can always reach the last index.

public class JumpGameII {
  public int jump(int[] nums) {
    int jumpCount = 0;
    int maxReachFromCurrentPos = 0;
    int prevMaxReach = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      // we keep track of the max possible reach from all the positions we have traversed so far
      maxReachFromCurrentPos = Math.max(maxReachFromCurrentPos, i + nums[i]);
      // once we get to the position of prevMaxReach, we know for a fact that from this position i,
      // we will be able to reach maxReachFromCurrentPos, because maxReachFromCurrentPos is achieved
      // from an index j < the current position i. In another words, to reach maxReachFromCurrentPos,
      // we just need to reach j, then from j, we can reach maxReachFromCurrentPos. Since i == prevMaxReach,
      // we know that we can reach i, therefore, we for sure can reach j, which is < i.
      // One key thing here is that we are guaranteed to be able to reach the last index. So in the end,
      // what we are saying is that, to reach maxReachFromCurrentPos, it takes jumpCount jumps to get to 
      // i, and then 1 more jump to get to maxReachFromCurrentPos, and since we are guaranteed to be able
      // to reach the last index, we will arrive at the right answer once we traverse through the entire array.
      if (i == prevMaxReach) {
        jumpCount++;
        prevMaxReach = maxReachFromCurrentPos;
      }
    }
    return jumpCount;
  }

  public static void Run() {
    JumpGameII j = new JumpGameII();
    System.out.println(j.jump(new int[]{2,3,1,1,4}));
    System.out.println(j.jump(new int[]{2,3,0,1,4}));
  }
}
