// There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal 
// money from the homes, but he refuses to steal from adjacent homes.
// The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
// You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left 
// has nums[i] dollars.
// You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal 
// at least k houses.
// Return the minimum capability of the robber out of all the possible ways to steal at least k houses.

public class HouseRobberIV {
  // This seems to work but it exceeds the max memory limit when k is large
  public int minCapability1(int[] nums, int k) {
    // define a state function DP[i][j] as follows:
    // DP[i][j] - the capacity value at house i and a total of j houses having been robbed
    //
    // Observe:
    // DP[i][j] = max(DP[i-1][j], max(DP[i-2][j-1], nums[i]))
    //
    // result = min(DP[0][k], DP[1][k], ... DP[n-1][k])
    int m = nums.length;
    if (m == 1)
      return nums[0];
    
    int[][] DP = new int[m][k+1];

    // the first 2 houses are simple: first initialize it to all 0s and then fill in the specific cases
    for (int j=0; j<=k; j++) {
      for (int i=0; i<m; i++)
        DP[0][j] = 0;
    }
    DP[0][1] = nums[0];
    DP[1][1] = Math.min(nums[0], nums[1]);

    for (int i=2; i<m; i++) {
      for (int j=0; j<=k; j++) {
        if (j == 0) {
          DP[i][j] = 0; // if you haven't robbed any house, then the capacity is 0
        } else if (j == 1) {
          DP[i][j] = Math.min(DP[i-1][j], Math.max(DP[i-2][j-1], nums[i]));
        } else {
          if (j > (i/2 + 1)) {
            break;
          }
          if (DP[i-2][j-1] == 0)
            DP[i][j] = DP[i-1][j]; // this is deduced from DP[i][j] = Math.max(DP[i-1][j], Math.max(DP[i-2][j-1], nums[i]));
                                   // if DP[i-2][j-1] == 0, you cannot jump from having robbed less than j-1 houses to robbing
                                   // j houses at house i
          else if (DP[i-1][j] == 0)
            DP[i][j] = Math.max(DP[i-2][j-1], nums[i]); 
          else
            DP[i][j] = Math.min(DP[i-1][j], Math.max(DP[i-2][j-1], nums[i]));
        }
      }
    }

    int result = Integer.MAX_VALUE;
    for (int i=0; i<m; i++) {
      if (DP[i][k] != 0)
      result = Math.min(result, DP[i][k]);
    }
    return result;
  }

  public int minCapability(int[] nums, int k) {
    int result = 0;
    int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] < l)
        l = nums[i];
      if (nums[i] > r)
        r = nums[i];
    }
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (isValidCapability(m, nums, k)) {
        result = m;
        r = m -1;
      } else {
        l = m + 1;
      }
    }
    return result;
  }

  private boolean isValidCapability(int c, int[] nums, int k) {
    int i = 0;
    int count = 0;
    while (i < nums.length) {
      if (nums[i] <= c) {
        i += 2;
        count++;
      } else {
        i += 1;
      }
      if (count >= k)
        return true;
    }
    return false;
  }

  public static void Run() {
    HouseRobberIV h = new HouseRobberIV();
    System.out.println(h.minCapability(new int[]{2,7,9,3,1}, 2));
    System.out.println(h.minCapability(new int[]{2,3,5,9}, 2));
    System.out.println(h.minCapability(new int[]{2,7,9,3,1}, 3));
  }
}
