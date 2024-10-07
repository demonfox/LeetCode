// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, 
// you can either climb one or two steps.
// You can either start from the step with index 0, or the step with index 1.
// Return the minimum cost to reach the top of the floor.


public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    // Define a state transition function DP[i], where:
    // DP[i+1] = min(DP[i] + cost[i], DP[i-1] + cost[i-1])
    int[] DP = new int[cost.length + 1];
    DP[0] = 0;
    DP[1] = 0; // since we can start at either index 0 or index 1
    for (int i=2; i<DP.length; i++) {
      DP[i] = Math.min(DP[i-1] + cost[i-1], DP[i-2] + cost[i-2]);
    }
    return DP[cost.length];
  }

  public static void Run() {
    MinCostClimbingStairs m = new MinCostClimbingStairs();
    int[] cost = new int[] {10, 15, 20};
    System.out.println(m.minCostClimbingStairs(cost));
    cost = new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(m.minCostClimbingStairs(cost));
  }
}
