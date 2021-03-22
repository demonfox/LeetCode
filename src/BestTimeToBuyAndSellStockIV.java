// You are given an integer array prices where prices[i] is the price of a given stock on 
// the ith day, and an integer k.
// Find the maximum profit you can achieve. You may complete at most k transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell 
// the stock before you buy again).
public class BestTimeToBuyAndSellStockIV {
  public int maxProfit(int k, int[] prices) {
    // define a state function DP[i][2][j] as follows:
    // DP[i][0][j] - the max profit on ith day holding 0 share and having made k
    // transaction, where j=0, 1, up to the input parameter "k"
    // DP[i][1][j] - the max profit on ith day holding 1 share and having made k
    // transaction, where j=0, 1, up to the input parameter "k"
    //
    // Observe:
    // DP[i][0][j] = max(DP[i-1][0][j], DP[i-1][1][j-1]+prices[i]) for j >=1
    // DP[i][1][j] = max(DP[i-1][1][j], DP[i-1][0][j]-prices[i])
    // 
    // When j = 0:
    // DP[i][0][0] = DP[i-1][0][0]
    // DP[i][1][0] = max(DP[i-1][1][0], DP[i-1][0][0]-prices[i])
    // When j = 1:
    // DP[i][0][1] = max(DP[i-1][0][1], DP[i-1][1][0]+prices[i])
    // DP[i][1][1] = max(DP[i-1][1][1], DP[i-1][0][1]-prices[i])
    //
    // result = max(DP[last_day][0][j] for j=0...k)
    int m = prices.length;
    if (m==0)
      return 0;

    int[][][] DP = new int[m][2][k+1];

    for (int j=0; j<=k; j++) {
      DP[0][0][j] = 0;
      DP[0][1][j] = (j==0) ? -prices[0] : Integer.MIN_VALUE;
      // DP[0][1][0] = -prices[0]; // first day, buy 1 share
      // for any other DP[0][1][j], we cannot get to own 1 share on the first day AND having completed any transactions,
      // so we set it to MIN_VALUE
    }

    for (int i=1; i<m; i++) {
      for (int j=0; j<=k; j++) {
        if (j == 0) {
          DP[i][0][j] = DP[i-1][0][j];
          DP[i][1][j] = Math.max(DP[i-1][1][j], DP[i-1][0][j]-prices[i]);
        } else {
          DP[i][0][j] = Math.max(DP[i-1][0][j], DP[i-1][1][j-1]+prices[i]);
          if (DP[i][0][j] == 0) {
            // we have not yet made j-1 transactions, so we cannot possibly arrive
            // at DP[i][1][j]
            DP[i][1][j] = Integer.MIN_VALUE;
          } else {
            // DP[i][0][j-1] > 0, meaning we have already made j-1 transactions            
            DP[i][1][j] = Math.max(DP[i-1][1][j], DP[i-1][0][j]-prices[i]);
          }
        }
      }
    }

    int result = 0;
    for (int j=0; j<=k; j++) {
      result = Math.max(DP[m-1][0][j], result);
    }
    return result;
  }

  public static void Run() {
    BestTimeToBuyAndSellStockIV b = new BestTimeToBuyAndSellStockIV();
    //System.out.println(b.maxProfit(2, new int[]{2,4,1}));
    //System.out.println(b.maxProfit(2, new int[]{3,2,6,5,0,3}));
    System.out.println(b.maxProfit(4, new int[]{5,7,2,7,3,3,5,3,0}));
  }
}
