// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the 
// stock before you buy again).

public class BestTimeToBuyAndSellStockIII {
  public int maxProfit(int[] prices) {
    if (prices.length < 2)
      return 0;
    // these two arrays record the best transactional profit you can find
    // to the left of prices[i] and to the right of prices[i]; or you can
    // say: find the best transactional price till day i, and the best
    // transactional profit from day i onwards
    int[] profits1 = new int[prices.length];
    int[] profits2 = new int[prices.length];
    int low = prices[0];
    int high = prices[prices.length - 1];
    int maxprofit = 0;

    for (int i = 0; i < prices.length; i++) {
      profits1[i] = Math.max(maxprofit, prices[i] - low);
      maxprofit = Math.max(maxprofit, profits1[i]);
      low = Math.min(low, prices[i]);
    }

    maxprofit = 0;

    for (int i = prices.length - 1; i >= 0; i--) {
      profits2[i] = Math.max(maxprofit, high - prices[i]);
      maxprofit = Math.max(maxprofit, profits2[i]);
      high = Math.max(high, prices[i]);
    }

    for (int i = 0; i < prices.length; i++) {
      maxprofit = Math.max(maxprofit, profits1[i] + profits2[i]);
    }

    return maxprofit;
  }

  // using dynamic programming
  public int maxProfit2(int[] prices) {
    // define a state function DP[i][2][2] as follows:
    // DP[i][0][k] - the max profit on ith day holding 0 share and having made k
    // transaction, where k=0, 1, or 2
    // DP[i][1][k] - the max profit on ith day holding 1 share and having made k
    // transaction, where k=0, 1, or 2
    // Observe:
    // DP[i][0][0] = DP[i-1][0][0]
    // DP[i][1][0] = max(DP[i-1][1][0], DP[i-1][0][0]-prices[i])
    // the above means: the max of "previous day holding 1 share, made 0 transaction" or "previous day holding 0 share, and buy today"
    // DP[i][0][1] = max(DP[i-1][0][1], DP[i-1][1][0]+prices[i])
    // the above means: the max of "previous day holding 0 share, made 1 transaction" or "previous day holding 1 share, made 0 transaction, and sell today"
    // DP[i][1][1] = max(DP[i-1][1][1], DP[i-1][0][1]-prices[i])
    // DP[i][0][2] = max(DP[i-1][0][2], DP[i-1][1][1]+prices[i])
    // result = max(DP[last_day][0][0], DP[last_day][0][1], DP[last_day][0][2])
    // holding any share on the last_day is stupid so the second dimension is gonna be 0, but the most profit
    // may come from making 0, 1, or 2 transactions
    int m = prices.length;
    int[][][] DP = new int[m][2][3];
    for (int k=0; k<3; k++)
      DP[0][0][k] = 0;
    DP[0][1][0] = -prices[0];
    DP[0][1][1] = Integer.MIN_VALUE;
    for (int i=1; i<m; i++) {
      DP[i][0][0] = DP[i-1][0][0];
      DP[i][1][0] = Math.max(DP[i-1][1][0], DP[i-1][0][0]-prices[i]);
      DP[i][0][1] = Math.max(DP[i-1][0][1], DP[i-1][1][0]+prices[i]);
      if (DP[i][0][1] == 0) { // DP[i][0][1] cannot be < 0 since it's an increasing sequence
        // this means we have not made any transactions yet, so we cannot possibly arrive
        // at DP[i][1][1] without having made one transaction
        DP[i][1][1] = Integer.MIN_VALUE;
      } else { // DP[i][0][1] > 0, meaning we have already made 1 transaction previously
        DP[i][1][1] = Math.max(DP[i-1][1][1], DP[i-1][0][1]-prices[i]);
        DP[i][0][2] = Math.max(DP[i-1][0][2], DP[i-1][1][1]+prices[i]);
      }
    }
    return Math.max(Math.max(DP[m-1][0][0], DP[m-1][0][1]), DP[m-1][0][2]);
  }

  public static void Run() {
    BestTimeToBuyAndSellStockIII s = new BestTimeToBuyAndSellStockIII();
    // System.out.println(s.maxProfit(new int[] {3,3,5,0,0,3,1,4}));
    // System.out.println(s.maxProfit(new int[] {1,2,3,4,5}));
    // System.out.println(s.maxProfit(new int[] {7,6,4,3,1}));
    // System.out.println(s.maxProfit(new int[] {1}));
    // System.out.println(s.maxProfit(new int[] { 5, 7, 2, 4, 9 }));
    // System.out.println(s.maxProfit2(new int[] { 5, 7, 2, 4, 9 }));
    // System.out.println(s.maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
    // System.out.println(s.maxProfit2(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
    System.out.println(s.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
    System.out.println(s.maxProfit2(new int[] { 1, 2, 3, 4, 5 }));
  }
}
