// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one 
// share of the stock multiple times) with the following restrictions:
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

public class BestTimeToBuyAndSellStockWithCD {
  // using dynamic programming
  public int maxProfit(int[] prices) {
    // define a state function DP[i][3] as follows:
    // DP[i][0] - the max profit on ith day holding 0 share
    // DP[i][1] - the max profit on ith day holding 1 share
    // DP[i][2] - the max profit on ith day CD'ing, and since CD only starts after
    // selling the stock, you must be holding 0 share
    // Observe:
    // DP[i][0] = max(DP[i-1][0], DP[i-1][2]) --- this shows you can not reach state 0, which is "ready to buy", 
    //                                            from state 1 directly; it has to transition from state 2
    // DP[i][1] = max(DP[i-1][1], DP[i-1][0] - prices[i])
    // DP[i][2] = DP[i-1][1] + prices[i]
    // result = DP[last_day][0] since we should notice DP[i][0] is an increasing
    // sequence
    // and still holding a share on the last_day is plain stupid
    int[][] DP = new int[prices.length][3];
    DP[0][0] = 0;
    DP[0][1] = -prices[0];
    DP[0][2] = 0;
    for (int i = 1; i < prices.length; i++) {
      DP[i][0] = Math.max(DP[i - 1][0], DP[i - 1][2]);
      DP[i][1] = Math.max(DP[i - 1][1], DP[i - 1][0] - prices[i]);
      DP[i][2] = DP[i - 1][1] + prices[i];
    }
    return Math.max(DP[prices.length-1][0], DP[prices.length-1][2]);
  }

  public static void Run() {
    BestTimeToBuyAndSellStockWithCD b = new BestTimeToBuyAndSellStockWithCD();
    int[] prices = { 1, 2, 3, 0, 2 };
    System.out.println(b.maxProfit(prices));

    prices = new int[]{ 1 };
    System.out.println(b.maxProfit(prices));
  }
}
